package com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans;

import java.util.List;

// Class added for serialization functionality when calling NASA's Rover photo API
// Should be in-line with exercises' example project
public class PhotoList {
    
    private List<Photo> photos;

    public PhotoList(List<Photo> photos) {
        this.photos = photos;
    } 

    public List<Photo> getPhotos() {
        return photos;
    }
}
