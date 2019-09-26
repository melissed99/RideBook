package com.example.doroteo_ridebook;

public class Ride {

    private String distance;
    private String speed;
    private String cadence;
    private String comments;

    Ride (String distance, String speed, String cadence, String comments){
        this.distance=distance;
        this.speed=speed;
        this.cadence=cadence;
        this.comments=comments;
    }

    //getters
    String getDistance(){
        return this.distance;
    }

    String getSpeed(){
        return this.speed;
    }

    String getCadence(){
        return this.cadence;
    }

    String getComments(){
        return this.comments;
    }

    //setters
    public void setDistance(String distance){
        this.distance=distance;
    }

    public void setSpeed(String speed){
        this.speed=speed;
    }

    public void setCadence(String cadence){
        this.cadence=cadence;
    }

    public void setComments(String comments){
        this.comments=comments;
    }

}
