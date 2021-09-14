package com.overonix.test.dto;

public class NominatiumAddressDTO implements AddressDTO {

    private String display_name;
    private double lon;
    private double lat;

    @Override
    public String getTitle() {
        return display_name;
    }

    @Override
    public double getLongitude() {
        return lon;
    }

    @Override
    public double getLatitude() {
        return lat;
    }

    public void setDisplay_name(String displayName) {
        this.display_name = displayName;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
