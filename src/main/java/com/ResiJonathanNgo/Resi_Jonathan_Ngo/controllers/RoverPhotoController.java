package com.ResiJonathanNgo.Resi_Jonathan_Ngo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.DateService;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.PhotoService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/")
public class RoverPhotoController {
    
    private final PhotoService photoService;
    private final DateService dateService;

    public RoverPhotoController(PhotoService photoService, DateService dateService) {
        this.photoService = photoService;
        this.dateService = dateService;
    }

    // Returns list of dates from requestBody (if given) or from text file (if requestBody not given)
    @GetMapping("dates")
    public ResponseEntity<?> readDates(@RequestBody(required = false) String body) {
        try {
            if (body != null) {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(dateService.getDates(body));
            } else {
                return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(dateService.getDates());
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // List of rovers
    @GetMapping("rovers")
    public ResponseEntity<?> getRovers() {
        try {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(photoService.getRovers());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // List of photos for single date
    @GetMapping("photos/list")
    public ResponseEntity<?> getPhotosList(
        @RequestParam(name = "rover_name", required = true) String name,
        @RequestParam(name = "earth_date", required = true) String date) {
        
        try {
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(photoService.getPhotosList(name, date));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    // Single photo
    @GetMapping("photos")
    public ResponseEntity<?> getPhoto(@RequestParam(name = "photo_link", required = true) String link) {
        
        try {
            Path path = photoService.getPhoto(link);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(Files.readAllBytes(path));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
