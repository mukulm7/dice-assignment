package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherAPIController {

    private final RestTemplate restTemplate;

    public WeatherAPIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/forecast-summary")
    public ResponseEntity<String> getWeatherForecastSummary(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+ city+"/summary/";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<String> getHourlyWeatherForecast(@RequestParam String city) {
    	String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+ city+"/hourly/";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
}
