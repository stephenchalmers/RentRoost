package com.techelevator.service;

import java.util.Map;

public interface GeocodingService {
    Map<String, Double> getGeocode(String inputAddress);
}
