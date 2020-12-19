package com.example.zometodemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BgColor implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tint")
    @Expose
    private String tint;
    private final static long serialVersionUID = -4530667031974260033L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BgColor() {
    }

    /**
     *
     * @param type
     * @param tint
     */
    public BgColor(String type, String tint) {
        super();
        this.type = type;
        this.tint = tint;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTint() {
        return tint;
    }

    public void setTint(String tint) {
        this.tint = tint;
    }

}
