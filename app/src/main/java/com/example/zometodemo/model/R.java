package com.example.zometodemo.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class R implements Serializable
{

    @SerializedName("res_id")
    @Expose
    private Integer resId;
    @SerializedName("is_grocery_store")
    @Expose
    private Boolean isGroceryStore;
    @SerializedName("has_menu_status")
    @Expose
    private HasMenuStatus hasMenuStatus;
    private final static long serialVersionUID = 5074146517821324967L;

    /**
     * No args constructor for use in serialization
     *
     */
    public R() {
    }

    /**
     *
     * @param isGroceryStore
     * @param hasMenuStatus
     * @param resId
     */
    public R(Integer resId, Boolean isGroceryStore, HasMenuStatus hasMenuStatus) {
        super();
        this.resId = resId;
        this.isGroceryStore = isGroceryStore;
        this.hasMenuStatus = hasMenuStatus;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Boolean getIsGroceryStore() {
        return isGroceryStore;
    }

    public void setIsGroceryStore(Boolean isGroceryStore) {
        this.isGroceryStore = isGroceryStore;
    }

    public HasMenuStatus getHasMenuStatus() {
        return hasMenuStatus;
    }

    public void setHasMenuStatus(HasMenuStatus hasMenuStatus) {
        this.hasMenuStatus = hasMenuStatus;
    }

}
