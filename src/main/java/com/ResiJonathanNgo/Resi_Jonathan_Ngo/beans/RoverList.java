package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

import java.util.List;

// Class added for serialization functionality when calling NASA's Rover photo API
// Should be in-line with exercises' example project
public class RoverList {
    
    private List<Rover> rovers;

    public RoverList(List<Rover> rovers) {
        this.rovers = rovers;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
