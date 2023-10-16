package com.techelevator.service;

import com.techelevator.KeyConfig;
import com.techelevator.model.Geocode.Geocode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestGeocodingService implements GeocodingService{
    public static String API_BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private RestTemplate restTemplate = new RestTemplate();
    private KeyConfig keyConfig = new KeyConfig();
    private String googleMapsApiKey = keyConfig.getGoogleMapsApiKey();


    @Override
    public Map<String, Double> getGeocode(String inputAddress) {
        String paramString = inputAddress.replace(" ", "%20");
        paramString = paramString.replace("#", "%23");
        paramString += "&key=" + googleMapsApiKey;

        Geocode geocode = restTemplate.getForObject(API_BASE_URL + paramString, Geocode.class);
        Map<String, Double> outputLocation = new HashMap<>();
        outputLocation.put("lat", geocode.getResults().get(0).getGeometry().getLocation().getLat());
        outputLocation.put("lng", geocode.getResults().get(0).getGeometry().getLocation().getLng());
        return outputLocation;
    }
}
