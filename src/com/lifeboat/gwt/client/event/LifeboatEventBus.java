package com.lifeboat.gwt.client.event;

import com.lifeboat.gwt.client.Util;
import com.lifeboat.gwt.client.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class LifeboatEventBus {

    private final Map<Class, List<Handler>> handlersMap = new HashMap<Class, List<Handler>>();

    public <T extends LifeboatEvent> void addHandler(Class<T> eventClass, Handler<T> handlerInstance) {
        Util.checkNullAndThrowNPE(eventClass, handlerInstance);
        List<Handler> handlers = handlersMap.get(eventClass);
        if (Util.isEmpty(handlers)) {
            handlers = new ArrayList<Handler>();
            handlersMap.put(eventClass, handlers);
        }
        handlers.add(handlerInstance);
    }

    public <T extends LifeboatEvent> void removeHandler(Class<T> eventClass, Handler<T> handlerInstance) {
        Util.checkNullAndThrowNPE(eventClass, handlerInstance);
        List<Handler> handlers = handlersMap.get(eventClass);
        if (handlers != null) {
            handlers.remove(handlerInstance);
        }
    }

    public <T extends LifeboatEvent> void removeHandler(Handler<T> handlerInstance) {
        Util.checkNullAndThrowNPE(handlerInstance);
        for (List<Handler> handlers : handlersMap.values()) {
            handlers.remove(handlerInstance);
        }
    }

    public void fireEvent(LifeboatEvent event) {
        Util.checkNullAndThrowNPE(event);
        try {
            for (Handler handler : handlersMap.get(event.getClass())) {
                handler.handle(event);
            }
        } catch (Exception e) {
            Console.error(e.getMessage());
        } finally {
            event.setAlive(false);
        }
    }

    <T extends LifeboatEvent> int handlersCount(Class<T> eventClass) {
        return Util.isEmpty(handlersMap.get(eventClass)) ? 0 : handlersMap.get(eventClass).size();
    }
}
