package com.techelevator.model;

import java.util.HashMap;
import java.util.Map;

public class Property {
    private int propertyId;
    private String propertyName;
    private String propertyAddress;
    private double propertyLat;
    private double propertyLng;
    private String propertyDescription;
    private int propertyBedrooms;
    private int propertyBathrooms;
    private double propertyRent;
    private boolean rented;
    private String imageUrl;
    private Map<String, Double> propertyPosition;
    private int landlordId;


    public Property(){};
    public Property(String propertyName, String propertyAddress, double propertyLat, double propertyLng, int propertyBedrooms, int propertyBathrooms, double propertyRent, boolean rented, String imageUrl) {
        this.propertyName = propertyName;
        this.propertyAddress = propertyAddress;
        this.propertyLat = propertyLat;
        this.propertyLng = propertyLng;
        this.propertyBedrooms = propertyBedrooms;
        this.propertyBathrooms = propertyBathrooms;
        this.propertyRent = propertyRent;
        this.rented = rented;
        this.imageUrl = imageUrl;
        this.propertyPosition.put("lat: ", propertyLat);
        this.propertyPosition.put("lng: ", propertyLng);
    }

    public Map getPropertyPosition() {
        this.propertyPosition = new HashMap<>();
        this.propertyPosition.put("lat", propertyLat);
        this.propertyPosition.put("lng", propertyLng);

        return this.propertyPosition;
    }

    public void setPropertyPosition(Map propertyPosition) {
        this.propertyPosition = propertyPosition;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public double getPropertyLat() {
        return propertyLat;
    }

    public void setPropertyLat(double propertyLat) {
        this.propertyLat = propertyLat;
    }

    public double getPropertyLng() {
        return propertyLng;
    }

    public void setPropertyLng(double propertyLng) {
        this.propertyLng = propertyLng;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public int getPropertyBedrooms() {
        return propertyBedrooms;
    }

    public void setPropertyBedrooms(int propertyBedrooms) {
        this.propertyBedrooms = propertyBedrooms;
    }

    public int getPropertyBathrooms() {
        return propertyBathrooms;
    }

    public void setPropertyBathrooms(int propertyBathrooms) {
        this.propertyBathrooms = propertyBathrooms;
    }

    public double getPropertyRent() {
        return propertyRent;
    }

    public void setPropertyRent(double propertyRent) {
        this.propertyRent = propertyRent;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", propertyBedrooms=" + propertyBedrooms +
                ", propertyBathrooms=" + propertyBathrooms +
                ", propertyRent=" + propertyRent +
                ", rented=" + rented +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
