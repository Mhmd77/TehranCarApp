package com.leopard.tehrancarapp.controller;

public enum ApiHandler {
    ADD_CAR("app/addCar"),;

    private static final String BASE_URL = "";
    ApiHandler(String url) {
        this.url = url;
    }

    private String url;

    public String getUrl() {
        return url;
    }
}
