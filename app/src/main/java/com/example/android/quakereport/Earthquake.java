package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by hamonteroa on 8/17/16.
 */
public class Earthquake {

    private double magnitude;
    private String distance;
    private String location;
    private Long timeInMilliseconds;
    private String url;

    public Earthquake(double magnitude, String distance, String location, Long timeInMilliseconds, String url) {
        this.magnitude = magnitude;
        this.distance = distance;
        this.location = location;
        this.timeInMilliseconds = timeInMilliseconds;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public void setTimeInMilliseconds(Long timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
