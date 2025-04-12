package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

public class Rover {

    private int id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;

    public Rover () {
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_landing_date() {
        return landing_date;
    }

    public void set_landing_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String get_launch_date() {
        return launch_date;
    }

    public void set_launch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String get_status() {
        return status;
    }

    public void set_status(String status) {
        this.status = status;
    }
}