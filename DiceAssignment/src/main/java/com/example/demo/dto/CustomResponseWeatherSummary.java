package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomResponseWeatherSummary {

	@JsonProperty("location")
	private Location location;
	
	@JsonProperty("forecast")
	private Forecast forecast;
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Forecast getForecast() {
		return forecast;
	}
	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}
	static class Location{
		@JsonProperty("code")
		private String code;
		
		@JsonProperty("name")
		private String name;
		
		@JsonProperty("timezone")
		private String timezone;
		
		@JsonProperty("coordinates")
		private Coordinates coordinates;
		
		
	}
	static class Coordinates{
		@JsonProperty("latitude")
		private double latitude;
		
		@JsonProperty("longitude")
		private double longitude;
	}
	static class Forecast{
		
		@JsonProperty("forecastDate")
		private String forecastDate;
		
		@JsonProperty("nextUpdate")
		private String nextUpdate;
		
		@JsonProperty("source")
		private String source;
		
		@JsonProperty("point")
		private String point;
	}
}
