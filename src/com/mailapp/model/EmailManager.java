package com.mailapp.model;

import javafx.scene.control.TreeItem;

public class EmailManager {
    private TreeItem<String> foldersRoot = new TreeItem<>("");

    public TreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }
}
