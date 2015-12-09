package com.culpeo.android;

import android.widget.ImageView;

/**
 * Created by Ross on 12/9/2015.
 */
public class News {

    private String title;
    private String authur;
    private String description;
    private String text;
    private int image;

    public News(String title, String auth, String desc, String text, int imageId){
        this.title = title;
        this.authur = auth;
        this.description = desc;
        this.text = text;
        this.image = imageId;
    }

    public int getImage(){
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAuthur() {
        return authur;
    }

    public String getDescription() {
        return description;
    }
}
