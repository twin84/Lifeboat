package com.lifeboat.gwt.client.event;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class LifeboatEventBusTest {

    @Test
    public void testBus() {
        final LifeboatEventBus bus = new LifeboatEventBus();
        final List<Handler> output = new ArrayList<Handler>();

        class TestHandler<T extends LifeboatEvent> implements Handler<T> {
            final String strName;

            public TestHandler(String strName) {
                this.strName = strName;
            }

            public void handle(T event) {
                output.add(this);
            }

            @Override
            public String toString() {
                return strName;
            }
        }

        class Event1 extends LifeboatEvent {
            Event1() {
                super(0);
            }
        }

        class Event2 extends LifeboatEvent {
            Event2() {
                super(1);
            }
        }

        final Handler<Event1> handler1 = new TestHandler<Event1>("handler1");
        final Handler<Event2> handler2 = new TestHandler<Event2>("handler2");
        final Handler handlerBoth = new TestHandler("handlerBoth");

        bus.addHandler(Event1.class, handler1);
        bus.addHandler(Event2.class, handler2);
        bus.addHandler(Event1.class, handlerBoth);
        bus.addHandler(Event2.class, handlerBoth);

        bus.fireEvent(new Event1());
        Assert.assertEquals(Arrays.asList(handler1, handlerBoth), output);
        output.clear();

        bus.fireEvent(new Event2());
        Assert.assertEquals(Arrays.asList(handler2, handlerBoth), output);
        output.clear();

        bus.fireEvent(new Event1());
        bus.fireEvent(new Event2());
        Assert.assertEquals(Arrays.asList(handler1, handlerBoth, handler2, handlerBoth), output);
        output.clear();

        Assert.assertEquals(2, bus.handlersCount(Event1.class));
        Assert.assertEquals(2, bus.handlersCount(Event2.class));

        bus.removeHandler(Event1.class, handlerBoth);
        Assert.assertEquals(1, bus.handlersCount(Event1.class));
        Assert.assertEquals(2, bus.handlersCount(Event2.class));

        bus.removeHandler(handler1);
        Assert.assertEquals(0, bus.handlersCount(Event1.class));
        Assert.assertEquals(2, bus.handlersCount(Event2.class));

        bus.removeHandler(handlerBoth);
        Assert.assertEquals(0, bus.handlersCount(Event1.class));
        Assert.assertEquals(1, bus.handlersCount(Event2.class));

        bus.removeHandler(handlerBoth);
        Assert.assertEquals(0, bus.handlersCount(Event1.class));
        Assert.assertEquals(1, bus.handlersCount(Event2.class));

        bus.removeHandler(handler2);
        Assert.assertEquals(0, bus.handlersCount(Event1.class));
        Assert.assertEquals(0, bus.handlersCount(Event2.class));
    }

    @Test
    public void testNulls() {
        final LifeboatEventBus bus = new LifeboatEventBus();
        assertException(new Command() {
            public void execute() {
                bus.addHandler(null, null);
            }
        });
        assertException(new Command() {
            public void execute() {
                bus.addHandler(null, new Handler<LifeboatEvent>() {
                    public void handle(LifeboatEvent event) {
                    }
                });
            }
        });
        assertException(new Command() {
            public void execute() {
                bus.addHandler(LifeboatEvent.class, null);
            }
        });
    }

    private void assertException(Command command) {
        boolean exception = false;
        try {
            command.execute();
        } catch (NullPointerException e) {
            exception = true;
        } finally {
            Assert.assertTrue(exception);
        }
    }

    private interface Command {
        void execute();
    }
}
