package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

public class Camera {

    private int id;
    private int rover_id;
    private String name;
    private String full_name;

    public Camera() {
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public int get_rover_id() {
        return rover_id;
    }

    public void set_rover_id(int rover_id) {
        this.rover_id = rover_id;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_full_name() {
        return full_name;
    }

    public void set_full_name(String full_name) {
        this.full_name = full_name;
    }
}