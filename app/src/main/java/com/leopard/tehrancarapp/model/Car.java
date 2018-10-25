package com.leopard.tehrancarapp.model;

public class Car {
    private String name;
    private String factory;
    private int year;
    private int kilometer;
    private String color;
    private String description;
    private boolean automate;
    private int price;

    private Car(String name, String factory, int year, int kilometer, String color, String description, boolean automate, int price) {
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

    public class CarBuilder {
        private String name;
        private String factory;
        private int year;
        private int kilometer;
        private String color;
        private String description;
        private boolean automate;
        private int price;

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CarBuilder setFactory(String factory) {
            this.factory = factory;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setKilometer(int kilometer) {
            this.kilometer = kilometer;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CarBuilder setAutomate(boolean automate) {
            this.automate = automate;
            return this;
        }

        public CarBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Car createCar() {
            return new Car(name, factory, year, kilometer, color, description, automate, price);
        }
    }
}
