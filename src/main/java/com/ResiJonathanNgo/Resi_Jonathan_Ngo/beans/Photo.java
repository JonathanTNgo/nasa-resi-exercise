package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

public class Photo {

    private int id;
    private int sol;
    private Camera camera;
    private String img_src;
    private String earth_date;
    private Rover rover;

    public Photo() {
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public int get_sol() {
        return sol;
    }

    public void set_sol(int sol) {
        this.sol = sol;
    }

    public Camera get_camera() {
        return camera;
    }

    public void set_camera(Camera camera) {
        this.camera = camera;
    }

    public String get_imgsrc() {
        return img_src;
    }

    public void set_imgsrc(String img_src) {
        this.img_src = img_src;
    }

    public String get_date() {
        return earth_date;
    }

    public void set_date(String earth_date) {
        this.earth_date = earth_date;
    }

    public Rover get_rover() {
        return rover;
    }

    public void set_rover(Rover rover) {
        this.rover = rover;
    }
}