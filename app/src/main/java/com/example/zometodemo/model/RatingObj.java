package com.example.zometodemo.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingObj implements Serializable
{

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("bg_color")
    @Expose
    private BgColor bgColor;
    private final static long serialVersionUID = 729872363313434656L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RatingObj() {
    }

    /**
     *
     * @param bgColor
     * @param title
     */
    public RatingObj(Title title, BgColor bgColor) {
        super();
        this.title = title;
        this.bgColor = bgColor;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public BgColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(BgColor bgColor) {
        this.bgColor = bgColor;
    }

}
