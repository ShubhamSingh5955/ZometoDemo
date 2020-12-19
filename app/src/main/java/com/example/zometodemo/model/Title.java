package com.example.zometodemo.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title implements Serializable
{

    @SerializedName("text")
    @Expose
    private String text;
    private final static long serialVersionUID = 7986813146416758771L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Title() {
    }

    /**
     *
     * @param text
     */
    public Title(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}