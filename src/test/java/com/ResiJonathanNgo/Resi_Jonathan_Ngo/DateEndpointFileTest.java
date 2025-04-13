package com.ResiJonathanNgo.Resi_Jonathan_Ngo;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.controllers.RoverPhotoController;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.DateService;

@SpringBootTest
public class DateEndpointFileTest {
    
    @Autowired
	private RoverPhotoController roverPhotoController;
	
	@Mock
	private DateService dateService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

    @Test
    public void test0() {
        when(dateService.getDates()).thenReturn(List.of("2017-02-27", "2018-06-02", "2016-07-13"));

        List<String> result = (List<String>) roverPhotoController.readDates(null).getBody();

        assertEquals(3, result.size());
        assertEquals("2017-02-27", result.get(0));
        assertEquals("2018-06-02", result.get(1));
        assertEquals("2016-07-13", result.get(2));
    }
}
