package com.example.myopenweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myopenweather.Interfaces.OpenWeatherServices;
import com.example.myopenweather.Models.Forecast;
import com.example.myopenweather.Models.RetrofitClientInstance;
import com.example.myopenweather.Models.Weather;
import com.example.myopenweather.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        OpenWeatherServices service =
                RetrofitClientInstance.getRetrofitInstance().create(OpenWeatherServices.
                        class);
        Call<Forecast> call = service.getForcast();
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast>
                    response) {
               Forecast forecast =  response.body();
               binding.txtVille.setText(forecast.getName());
               binding.txtTemp.setText(String.valueOf(forecast.getWeather().getTemp()));
               binding.txtTempMin.setText(String.valueOf(forecast.getWeather().getTemp_min()));
               binding.txtTempMax.setText(String.valueOf(forecast.getWeather().getTemp_max()));
               binding.txtHumidity.setText(String.valueOf(forecast.getWeather().getHumidity() + "%"));


            }
            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}