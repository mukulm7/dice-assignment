package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CustomResponseWeatherSummary;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/weather")
public class WeatherAPIController {

    private final RestTemplate restTemplate;

    public WeatherAPIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/forecast-summary")
    public ResponseEntity<Object> getWeatherForecastSummary(@RequestParam String city) {
        String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+ city+"/summary/";
        Object response = restTemplate.getForObject(url, Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CustomResponseWeatherSummary response2= mapper.convertValue(response, CustomResponseWeatherSummary.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hourly-forecast")
    public ResponseEntity<Object> getHourlyWeatherForecast(@RequestParam String city) {
    	String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/"+ city+"/hourly/";
    	Object response = restTemplate.getForObject(url, Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return ResponseEntity.ok(response);
    }
}
