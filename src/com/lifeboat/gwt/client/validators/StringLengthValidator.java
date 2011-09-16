package com.lifeboat.gwt.client.validators;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.lifeboat.gwt.client.Util;
import com.lifeboat.gwt.client.text.LifeboatConstants;

/**
 * @author Anton Bliznets
 * @since 13.09.11
 */
public class StringLengthValidator implements Validator {
    public static final int DEFAULT_MAX_LENGTH = 20;

    private final int maxFieldLength;

    public StringLengthValidator() {
        this(DEFAULT_MAX_LENGTH);
    }

    public StringLengthValidator(int maxFieldLength) {
        this.maxFieldLength = maxFieldLength;
    }

    public String validate(Field<?> field, String value) {
        String result = null;
        if (Util.isEmpty((String) field.getValue())) {
            result = LifeboatConstants.INSTANCE.validatorFieldEmpty();
        }
        if ((field.getValue()).toString().length() > maxFieldLength) {
            result = LifeboatConstants.INSTANCE.validatorFieldTooLong();
        }
        return result;
    }
}