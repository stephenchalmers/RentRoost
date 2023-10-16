package com.techelevator.model;

public class Tenant {

    private int tenantId;
    private String tenantName;
    private String tenantPhone;
    private String tenantEmail;
    private int rent;
    private int overdue;
    private boolean paid;
    private int tenantLandlord;
    private String tenantAddress;

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getOverdue() {
        return overdue;
    }

    public void setOverdue(int overdue) {
        this.overdue = overdue;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getTenantLandlord() {
        return tenantLandlord;
    }

    public void setTenantLandlord(int tenantLandlord) {
        this.tenantLandlord = tenantLandlord;
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress;
    }


    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getTenantName(), getTenantEmail(), getTenantId());
    }
}
