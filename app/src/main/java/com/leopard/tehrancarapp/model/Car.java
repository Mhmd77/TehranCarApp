package com.leopard.tehrancarapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Car implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("factory")
    private String factory;
    @SerializedName("year")
    private int year;
    @SerializedName("kilometer")
    private int kilometer;
    @SerializedName("color")
    private String color;
    @SerializedName("description")
    private String description;
    @SerializedName("automate")
    private boolean automate;
    @SerializedName("price")
    private int price;

    public Car(String name, String factory, int year, int kilometer, String color, String description, boolean automate, int price) {
        this.name = name;
        this.factory = factory;
        this.year = year;
        this.kilometer = kilometer;
        this.color = color;
        this.description = description;
        this.automate = automate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getFactory() {
        return factory;
    }

    public int getYear() {
        return year;
    }

    public int getKilometer() {
        return kilometer;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAutomate() {
        return automate;
    }

    public int getPrice() {
        return price;
    }

}
