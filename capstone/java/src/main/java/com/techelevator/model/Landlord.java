package com.techelevator.model;

public class Landlord {

    private int landlordId;
    private String landlordName;
    private String landlordEmail;
    private String landlordPhone;

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getLandlordEmail() {
        return landlordEmail;
    }

    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    public String getLandlordPhone() {
        return landlordPhone;
    }

    public void setLandlordPhone(String landlordPhone) {
        this.landlordPhone = landlordPhone;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getLandlordName(), getLandlordEmail(), getLandlordId());
    }
}