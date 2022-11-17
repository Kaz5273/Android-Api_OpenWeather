package com.example.myopenweather.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
        @SerializedName("temp")
        private Double temp;
        @SerializedName("feels_like")
        private Double feelsLike;
        @SerializedName("temp_min")
        private Double temp_min;
        @SerializedName("temp_max")
        private Double temp_max;
        @SerializedName("humidity")
        private int humidity;

        public Weather(double temp, double temp_min, double temp_max, int humidity){
                this.temp = temp;
                this.temp_min = temp_min;
                this.temp_max = temp_max;
                this.humidity = humidity;
        }


        public double getTemp() {
                return temp;
        }

        public double getTemp_min() {
                return temp_min;
        }

        public double getTemp_max() {
                return temp_max;
        }

        public int getHumidity() {
                return humidity;
        }
}
