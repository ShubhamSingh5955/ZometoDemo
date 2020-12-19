package com.example.zometodemo;

import com.example.zometodemo.model.Restaurant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable
    {

        @SerializedName("results_found")
        @Expose
        private Integer resultsFound;
        @SerializedName("results_start")
        @Expose
        private Integer resultsStart;
        @SerializedName("results_shown")
        @Expose
        private Integer resultsShown;
        @SerializedName("restaurants")
        @Expose
        private List<Restaurant> restaurants ;

        public ApiResponse() {
        }
        public ApiResponse(Integer resultsFound, Integer resultsStart, Integer resultsShown, List<Restaurant> restaurants) {
            super();
            this.resultsFound = resultsFound;
            this.resultsStart = resultsStart;
            this.resultsShown = resultsShown;
            this.restaurants = restaurants;
        }

        public Integer getResultsFound() {
            return resultsFound;
        }

        public void setResultsFound(Integer resultsFound) {
            this.resultsFound = resultsFound;
        }

        public Integer getResultsStart() {
            return resultsStart;
        }

        public void setResultsStart(Integer resultsStart) {
            this.resultsStart = resultsStart;
        }

        public Integer getResultsShown() {
            return resultsShown;
        }

        public void setResultsShown(Integer resultsShown) {
            this.resultsShown = resultsShown;
        }

        public List<Restaurant> getRestaurants() {
            return restaurants;
        }

        public void setRestaurants(List<Restaurant> restaurants) {
            this.restaurants = restaurants;
        }

    }

