package com.mailapp.controller;

import com.mailapp.model.EmailManager;
import com.mailapp.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    @FXML private MenuItem closeWindowMenu;
    @FXML private MenuItem deleteMenu;
    @FXML private WebView emailWebView;
    @FXML private TreeView<String> emailTreeView;
    @FXML private TableView<?> emailTableView;
    @FXML private TableColumn<?, ?> senderEmail;
    @FXML private TableColumn<?, ?> dateEmail;
    @FXML private TableColumn<?, ?> recipientsEmail;
    @FXML private TableColumn<?, ?> subjectEmail;

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpEmailTreeView();
    }

    private void setUpEmailTreeView() {
        emailTreeView.setRoot(emailManager.getFoldersRoot());
        emailTreeView.setShowRoot(false);
    }

    @FXML public void showLayoutControllerWindow() {
        viewFactory.showLayoutSettingsWindow();
    }

    @FXML public void showLoginWindow() {
        viewFactory.showLoginPage();
    }

    @FXML public void showSignUpPage() {
        viewFactory.showSignUpWindow();
    }

    @FXML public void showAboutsPage() {

    }

}
