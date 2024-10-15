package org.example.controller;

import org.example.DataTransferObject.Weather;
import org.example.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Разработайте RESTful API,
 * которое принимает название города и возвращает информацию о
 *погоде в этом городе. Для простоты возвращайте заранее определенные
 *  данные.
 *
 *  Добавьте возможность добавлять новый город и заменять старую погоду
 */

@RestController
@RequestMapping(path = "/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("{city}")
    public Weather getWeatherByCity(@PathVariable("city") String city){
        return weatherService.getWeather(city);
    }

    @PostMapping("/add")
    public void saveOrUpdate(@RequestBody Weather weather){
        weatherService.saveOrUpdate(weather);
    }

    @GetMapping("/all")
    public Collection<Weather> getAll(){
        return weatherService.allInfo();
    }
}
