package com.example.locationsharing.model;

import androidx.annotation.DrawableRes;

import java.io.Serializable;


public class Jewellery implements Serializable {
    private String name;
    private String price;
    @DrawableRes
    private int img;
    private String description;

    public Jewellery(String name, String price, @DrawableRes int img, String description) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(@DrawableRes int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return img;
    }
}
