package com.example.zometodemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AllReviews implements Serializable
{

    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;
    private final static long serialVersionUID = -7472578404961256758L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AllReviews() {
    }

    /**
     *
     * @param reviews
     */
    public AllReviews(List<Review> reviews) {
        super();
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
