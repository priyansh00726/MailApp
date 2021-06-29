package com.mailapp.controller;

import com.mailapp.model.EmailManager;
import com.mailapp.view.ViewFactory;

public class SignUpWindowController extends BaseController{

    public SignUpWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
}
