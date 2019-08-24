package com.asianapp.mohankumardhakal.athithi.random;

import android.graphics.Bitmap;

import java.io.Serializable;

public class ModelClass implements Serializable {
    String title;
    String description;
    int imageId;

    public ModelClass(String title, String description,int imageId) {
        this.title = title;
        this.description = description;
        this.imageId=imageId;
    }

    public void setImage(int image) {
        imageId = image;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
