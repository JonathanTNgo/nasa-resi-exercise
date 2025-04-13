package com.ResiJonathanNgo.Resi_Jonathan_Ngo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.Photo;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.PhotoList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.Rover;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.RoverList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.controllers.RoverPhotoController;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.PhotoService;

@SpringBootTest
public class ControllerEndpointTests {
    
    @Autowired
	private RoverPhotoController roverPhotoController;
	
	@MockitoBean
	private PhotoService photoService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

    @Test
    // Rovers list endpoint
    public void test0() {
        Rover curiosity = new Rover(5, "Curiosity", "2012-08-06", "2011-11-26", "active");
        Rover spirit = new Rover(7, "Spirit", "2004-01-04", "2003-06-10", "complete");
        RoverList expected = new RoverList(List.of(curiosity, spirit));

        when(photoService.getRovers()).thenReturn(expected);
        RoverList result = (RoverList) roverPhotoController.getRovers().getBody();

        verify(photoService).getRovers();
        
        List<Rover> rovers = result.getRovers();

        assertEquals(2, rovers.size());
        assertEquals(curiosity, rovers.get(0));
        assertEquals(spirit, rovers.get(1));
    }

    @Test
    // Photos list endpoint
    public void test1() {
        Photo a = new Photo(1);
        Photo b = new Photo(2);
        PhotoList expected = new PhotoList(List.of(new Photo(1), new Photo(2)));

        when(photoService.getPhotosList("Dummy rover", "Dummy date")).thenReturn(expected);
        PhotoList result = (PhotoList) roverPhotoController.getPhotosList("Dummy rover", "Dummy date").getBody();

        List<Photo> photos = result.getPhotos();

        assertEquals(2, photos.size());
        assertEquals(a, photos.get(0));
        assertEquals(b, photos.get(1));
    }
}

