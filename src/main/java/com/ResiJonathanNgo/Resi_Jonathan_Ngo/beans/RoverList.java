package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

import java.util.List;

public class RoverList {
    
    public List<Rover> rovers;

    public RoverList(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
