package com.example.zometodemo.model;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HasMenuStatus implements Serializable
{

    @SerializedName("delivery")
    @Expose
    private Boolean delivery;
    @SerializedName("takeaway")
    @Expose
    private Integer takeaway;
    private final static long serialVersionUID = -7220816066730828332L;

    /**
     * No args constructor for use in serialization
     *
     */
    public HasMenuStatus() {
    }

    /**
     *
     * @param delivery
     * @param takeaway
     */
    public HasMenuStatus(Boolean delivery, Integer takeaway) {
        super();
        this.delivery = delivery;
        this.takeaway = takeaway;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Integer getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(Integer takeaway) {
        this.takeaway = takeaway;
    }

}
