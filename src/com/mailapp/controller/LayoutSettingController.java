package com.mailapp.controller;

import com.mailapp.model.EmailManager;
import com.mailapp.view.ViewFactory;
import com.mailapp.view.enums.FontSizePicker;
import com.mailapp.view.enums.ThemePicker;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutSettingController extends BaseController implements Initializable {

    @FXML private ChoiceBox<ThemePicker> themeChoiceBox;
    @FXML private Slider fontSlider;
    @FXML private Button cancelButton;
    @FXML private Button applyButton;

    public LayoutSettingController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTheme();
        initializeFont();
    }

    private void initializeFont() {
        fontSlider.setMin(0);
        fontSlider.setMax(FontSizePicker.values().length - 1);
        fontSlider.setValue(viewFactory.getFontSizePicker().ordinal());
        fontSlider.setMajorTickUnit(1);
        fontSlider.setMinorTickCount(0);
        fontSlider.setBlockIncrement(1);
        fontSlider.setSnapToTicks(true);
        fontSlider.setShowTickMarks(true);
        fontSlider.setShowTickLabels(true);
        fontSlider.setLabelFormatter(new StringConverter<>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSizePicker.values()[i].toString();
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        fontSlider.valueProperty().addListener((obs, oldVal, newVal) -> fontSlider.setValue(newVal.intValue()));
    }

    private void initializeTheme() {
        themeChoiceBox.setItems(FXCollections.observableArrayList(ThemePicker.values()));
        themeChoiceBox.setValue(viewFactory.getThemePicker());
    }

    @FXML public void applyAction() {
        viewFactory.setFontSizePicker(FontSizePicker.values()[(int) fontSlider.getValue()]);
        viewFactory.setThemePicker(themeChoiceBox.getValue());
        viewFactory.updateStyles();
    }

    @FXML public void cancelAction() {
        viewFactory.closeStage((Stage) themeChoiceBox.getScene().getWindow());
    }
}
