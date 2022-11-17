package com.example.myopenweather.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Forecast implements Serializable {


    @SerializedName("main")
    Weather weather;
    @SerializedName("dt")
    private int datetime;
    @SerializedName("name")
    private String name;



    public Forecast(Weather weather, int datetime, String name) {
        this.weather = weather;
        this.datetime = datetime;
        this.name = name;
    }

    public int getDatetime() {
        return datetime;
    }

    public String getName() {
        return name;
    }
    public Weather getWeather() {
        return weather;
    }
}


