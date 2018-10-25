package com.leopard.tehrancarapp.model;

import java.io.Serializable;

public class Car implements Serializable {
    private String name;
    private String factory;
    private int year;
    private int kilometer;
    private String color;
    private String description;
    private boolean automate;
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
