package org.example.service;

import org.example.DataTransferObject.Weather;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherService {
    private static final List<Weather> WEATHERS = List.of(
            new Weather("London",22.2,10),
            new Weather("Berlin",12.2,11),
            new Weather("Bern",32.2,12)
    );
    private Map<String,Weather> cityToWeather;

    public WeatherService() {
        cityToWeather = WEATHERS.stream().collect(Collectors.toMap(w->w.city(),w->w));
    }

    public Weather getWeather(String city){
        if(!cityToWeather.containsKey(city)){
            throw new IllegalArgumentException("Invalid city");
        }
        return cityToWeather.get(city);
    }

    public void saveOrUpdate(Weather weather){
        if(weather == null){
            throw new NullPointerException("weather is null");
        }
        if(weather.city() == null || weather.city().isBlank()){
            throw new IllegalArgumentException("city is empty");
        }
        cityToWeather.put(weather.city(),weather);
    }

    public Collection<Weather> allInfo(){
        return cityToWeather.values();
    }

}
