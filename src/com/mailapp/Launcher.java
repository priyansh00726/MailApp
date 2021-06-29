package com.mailapp;

import com.mailapp.model.EmailManager;
import com.mailapp.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginPage();
//        viewFactory.showLayoutSettingsWindow();
    }
}
