package com.mailapp.view.enums;

import com.mailapp.view.ViewFactory;

import java.io.File;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Objects;

public enum ThemePicker {
    LIGHT,
    DARK,
    DEFAULT;

    public String getCssPath() {
        String path = "";
        switch (this) {
            case LIGHT : path =  "css/themeLight.css"; break;
            case DARK : path =  "css/themeDark.css"; break;
            default : path =  "css/themeDefault.css"; break;
        }
        return Objects.requireNonNull(ViewFactory.class.getResource(path)).toExternalForm();
    }
}
