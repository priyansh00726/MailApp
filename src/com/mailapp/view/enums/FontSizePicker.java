package com.mailapp.view.enums;

import com.mailapp.view.ViewFactory;

import java.util.Objects;

public enum FontSizePicker {
    LARGE,
    MEDIUM,
    SMALL;

    public String getCssPath() {
        String path = "";
        switch (this) {
            case LARGE : path = "css/fontBig.css"; break;
            case SMALL : path = "css/fontSmall.css"; break;
            default : path = "css/default.css"; break;
        }
        return Objects.requireNonNull(ViewFactory.class.getResource(path)).toExternalForm();
    }
}
