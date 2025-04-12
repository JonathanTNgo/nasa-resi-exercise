package com.ResiJonathanNgo.Resi_Jonathan_Ngo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.PhotoService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/")
public class RoverPhotoController {
    
    private final PhotoService photoService;

    public RoverPhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    // List of rovers
    @GetMapping("rovers")
    public ResponseEntity<?> getRovers() {
        try {
            ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(photoService.getRovers());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // List of photos for single date
    @GetMapping(value = "photos/list")
    public ResponseEntity<?> getPhotosList(
        @RequestParam(name = "rover_name", required = true) String name,
        @RequestParam(name = "earth_date", required = true) String date) {
        
        try {
            ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(photoService.getPhotosList(name, date));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    // Single photo
    @GetMapping(value = "photos")
    public ResponseEntity<?> getPhoto(
        @RequestParam(name = "rover_name", required = true) String name,
        @RequestParam(name = "photo_id", required = true) int id,
        @RequestParam(name = "photo_link", required = true) String link) {
        
        try {
            File file = photoService.getPhoto(name, id, link);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(file.toPath()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
