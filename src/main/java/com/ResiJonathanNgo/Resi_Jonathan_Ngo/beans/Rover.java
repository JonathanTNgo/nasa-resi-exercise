package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

public class Rover {

    private int id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;

    public Rover (int id, String name, String landing_date, String launch_date, String status) {
        this.id = id;
        this.name = name;
        this.landing_date = landing_date;
        this.launch_date = launch_date;
        this.status = status;
    }

    public Rover() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    // Two rovers are equal if all their fields match
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Rover other = (Rover) o;

        return (
            id == other.getId() &&
            name == other.getName() &&
            landing_date == other.getLanding_date() &&
            launch_date == other.getLaunch_date() &&
            status == other.getStatus()
        );
    }

    @Override
    public String toString() {
        return id + ""; 
    }
}