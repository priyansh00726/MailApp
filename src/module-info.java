module MailApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires activation;
    requires java.mail;
    requires javafx.web;

    opens com.mailapp.controller;
    opens com.mailapp.model;
    opens com.mailapp.view.fxml;
    opens com.mailapp.view.css;
}