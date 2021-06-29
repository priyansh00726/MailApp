package com.mailapp.model;

import javafx.scene.control.TreeItem;

public class EmailTreeItem extends TreeItem<String> {
    private String folderName;

    public EmailTreeItem(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }
}
