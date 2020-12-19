package com.example.zometodemo.model;


import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review implements Serializable
{

    @SerializedName("review")
    @Expose
    private List<Object> review = null;
    private final static long serialVersionUID = 1865523395762729223L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Review() {
    }

    /**
     *
     * @param review
     */
    public Review(List<Object> review) {
        super();
        this.review = review;
    }

    public List<Object> getReview() {
        return review;
    }

    public void setReview(List<Object> review) {
        this.review = review;
    }

}