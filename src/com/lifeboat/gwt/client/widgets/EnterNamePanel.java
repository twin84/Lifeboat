package com.lifeboat.gwt.client.widgets;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.*;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.lifeboat.gwt.client.validators.StringLengthValidator;
import com.lifeboat.gwt.client.text.LifeboatConstants;
import net.auroris.ColorPicker.client.ColorPicker;

/**
 * @author Anton Bliznets
 * @since 15.09.11
 */
public class EnterNamePanel extends FormPanel {
    private static final String DEFAULT_COLOR = "black";
    private static final int FORM_WIDTH = 300;

    private String color = DEFAULT_COLOR;
    private final Dialog colorPickerDialog = new Dialog();
    private final ColorPicker colorPicker = new ColorPicker();

    public EnterNamePanel(final EnterNameDialogListener listener) {
        setHeading(LifeboatConstants.INSTANCE.dlgEnterNameTitle());
        setFrame(true);
        HTML widget = new HTML(LifeboatConstants.INSTANCE.dlgEnterNameText());
        widget.addStyleName("x-form-item");
        widget.getElement().getStyle().setPaddingBottom(15, Style.Unit.PX);
        add(widget);

        final TextField<String> name = new TextField<String>();
        name.setFieldLabel(LifeboatConstants.INSTANCE.dlgEnterNameFieldName());
        name.setValidator(new StringLengthValidator());
        name.setAllowBlank(false);
        name.getFocusSupport().setPreviousId(getButtonBar().getId());


        add(name);

        final Grid grid = new Grid(1, 1);
        grid.setCellPadding(0);
        grid.setCellSpacing(0);
        grid.setWidget(0, 0, new HTML(LifeboatConstants.INSTANCE.dlgEnterNameFieldColorHint()));
        grid.getCellFormatter().setAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);
        grid.setHeight("22px");
        final Style style = grid.getElement().getStyle();
        initColorPickerDialog(style);
        style.setColor("#fff");

        style.setBackgroundColor(color);
        style.setCursor(Style.Cursor.POINTER);
        AdapterField adapterField = new AdapterField(grid);
        adapterField.setFieldLabel(LifeboatConstants.INSTANCE.dlgEnterNameFieldColor());
        add(adapterField);
        grid.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                colorPickerDialog.show();
            }
        });
        final Button button = new Button(LifeboatConstants.INSTANCE.dlgBtnOk());
        button.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                if (name.validate()) {
                    removeFromParent();
                    listener.onNameEntered(name.getValue(), color);
                }
            }
        });
        button.setWidth(100);
        addButton(button);
        setButtonAlign(com.extjs.gxt.ui.client.Style.HorizontalAlignment.RIGHT);
        button.getElement().getStyle().setMarginRight(20, Style.Unit.PX);
    }

    public void show() {
        RootPanel.get().add(this);
        getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
        getElement().getStyle().setLeft((Window.getClientWidth() - FORM_WIDTH) / 2, Style.Unit.PX);
        getElement().getStyle().setTop((Window.getClientHeight() - getOffsetHeight()) / 2, Style.Unit.PX);
    }

    private void initColorPickerDialog(final Style style) {
        colorPicker.getElement().getStyle().setMargin(10, Style.Unit.PX);
        colorPickerDialog.getButtonBar().removeAll();
        Button okBtn = new Button(LifeboatConstants.INSTANCE.dlgBtnSelectColor());
        okBtn.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                colorPickerDialog.hide();
                color = colorPicker.getHexColor();
                style.setBackgroundColor("#" + color);
            }
        });
        colorPickerDialog.setFocusWidget(okBtn);
        colorPickerDialog.addButton(okBtn);

        colorPickerDialog.setHideOnButtonClick(true);
        colorPickerDialog.setWidth(450);
        colorPickerDialog.add(colorPicker);
    }

    public interface EnterNameDialogListener {
        void onNameEntered(String name, String hexColor);
    }
}