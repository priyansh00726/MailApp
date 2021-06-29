package com.mailapp.controller;

import com.mailapp.controller.services.EmailLoginResult;
import com.mailapp.controller.services.LoginService;
import com.mailapp.model.EmailAccount;
import com.mailapp.model.EmailManager;
import com.mailapp.view.ViewFactory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML private PasswordField password;
    @FXML private TextField username;
    @FXML private Button submitButton;
    @FXML private Label errorLabel;
    @FXML private ProgressBar loginProgress;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginProgress.setDisable(true);
        loginProgress.setVisible(false);
    }

    @FXML public void loginSubmission() {
        errorLabel.setText("");
        if (ifFieldsAreValid()) {
            loginProgress.setDisable(false);
            loginProgress.setVisible(true);
            EmailAccount emailAccount = new EmailAccount(username.getText(), password.getText());
            LoginService service = new LoginService(emailManager, emailAccount);
            service.start();
            loginProgress.progressProperty().bind(service.progressProperty());
            service.setOnSucceeded(e -> {
                EmailLoginResult loginResult = service.getValue();
                switch (loginResult) {
                    case SUCCESS:
                        System.out.println("Login Successfully : " + emailAccount);
                        viewFactory.closeStage((Stage) username.getScene().getWindow());
                        viewFactory.showMainWindow();
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Credentials are wrong. Try Again !!!");
                        return;
                    case FAILED_BY_NETWORK:
                        errorLabel.setText("Network Problem. Try Again !");
                        return;
                    default:
                        errorLabel.setText("Unexpected Error !");
                }
            });
        }
    }

    private boolean ifFieldsAreValid() {
        if (username.getText().isEmpty()) {
            errorLabel.setText("Username is empty. Please enter the username.");
            return false;
        }
        if (password.getText().isEmpty()) {
            errorLabel.setText("Password is empty. Please enter the password.");
            return false;
        }
        return true;
    }
}
