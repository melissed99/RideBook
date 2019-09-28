package com.example.doroteo_ridebook;

public class Ride {

    private String date;
    private String time;
    private String distance;
    private String speed;
    private String cadence;
    private String comments;

    Ride (String date, String time, String distance, String speed, String cadence, String comments){
        this.date = date;
        this.time=time;
        this.distance=distance;
        this.speed=speed;
        this.cadence=cadence;
        this.comments=comments;
    }

    //getters

    String getDate(){ return this.date; }

    String getTime(){ return this.time; }

    String getDistance(){ return this.distance; }

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

    public void setDate(String date) { this.date = date; }

    public void setTime(String time) { this.time = time; }

    public void setDistance(String distance){
        this.distance=distance;
    }

    public void setSpeed(String speed){
        this.speed=speed;
    }

    public void setCadence(String cadence){ this.cadence=cadence; }

    public void setComments(String comments){
        this.comments=comments;
    }

}
