package com.example.taskapp.ui.onBoardScreen;

public class OnBoardModel {
    private String title, description;
    private Integer image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public OnBoardModel(String title, String description, Integer image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
