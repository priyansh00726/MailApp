package com.mailapp.view;

import com.mailapp.controller.*;
import com.mailapp.model.EmailManager;
import com.mailapp.view.enums.FontSizePicker;
import com.mailapp.view.enums.ThemePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private FontSizePicker fontSizePicker = FontSizePicker.MEDIUM;
    private ThemePicker themePicker = ThemePicker.DEFAULT;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        this.activeStages = new ArrayList<>();
    }

    public void initialiseStage(BaseController controller) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        loader.setController(controller);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        activeStages.add(stage);
        updateStyles();
    }

    public void closeStage(Stage stage) {
        activeStages.remove(stage);
        stage.close();
    }

    public void showLoginPage() {
        BaseController controller = new LoginWindowController(emailManager, this, "LoginPage");
        initialiseStage(controller);
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow");
        initialiseStage(controller);
    }

    public void showLayoutSettingsWindow() {
        BaseController controller = new LayoutSettingController(emailManager, this, "OptionsWindow");
        initialiseStage(controller);
    }

    public void showSignUpWindow() {
        BaseController controller = new SignUpWindowController(emailManager, this, "SignUpWindow");
        initialiseStage(controller);
    }


    public FontSizePicker getFontSizePicker() {
        return fontSizePicker;
    }

    public void setFontSizePicker(FontSizePicker fontSizePicker) {
        this.fontSizePicker = fontSizePicker;
    }

    public ThemePicker getThemePicker() {
        return themePicker;
    }

    public void setThemePicker(ThemePicker themePicker) {
        this.themePicker = themePicker;
    }

    public void updateStyles() {
        for (Stage stage : activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(themePicker.getCssPath());
            scene.getStylesheets().add(fontSizePicker.getCssPath());
        }
    }
}
