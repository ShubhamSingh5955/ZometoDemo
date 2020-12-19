package com.example.zometodemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Example implements Serializable
{

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;
    private final static long serialVersionUID = 6514315324151819570L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Example() {
    }

    /**
     *
     * @param restaurant
     */
    public Example(Restaurant restaurant) {
        super();
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
