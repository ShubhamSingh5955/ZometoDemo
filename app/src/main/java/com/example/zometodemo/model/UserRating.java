package com.example.zometodemo.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating implements Serializable
{

    @SerializedName("aggregate_rating")
    @Expose
    private String aggregateRating;
    @SerializedName("rating_text")
    @Expose
    private String ratingText;
    @SerializedName("rating_color")
    @Expose
    private String ratingColor;
    @SerializedName("rating_obj")
    @Expose
    private RatingObj ratingObj;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    private final static long serialVersionUID = 9184335239209883009L;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserRating() {
    }

    /**
     *
     * @param ratingObj
     * @param ratingColor
     * @param votes
     * @param ratingText
     * @param aggregateRating
     */
    public UserRating(String aggregateRating, String ratingText, String ratingColor, RatingObj ratingObj, Integer votes) {
        super();
        this.aggregateRating = aggregateRating;
        this.ratingText = ratingText;
        this.ratingColor = ratingColor;
        this.ratingObj = ratingObj;
        this.votes = votes;
    }

    public String getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public RatingObj getRatingObj() {
        return ratingObj;
    }

    public void setRatingObj(RatingObj ratingObj) {
        this.ratingObj = ratingObj;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

}