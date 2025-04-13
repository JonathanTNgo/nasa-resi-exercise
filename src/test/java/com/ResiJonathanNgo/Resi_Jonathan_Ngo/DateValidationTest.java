package com.ResiJonathanNgo.Resi_Jonathan_Ngo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.ResiJonathanNgo.Resi_Jonathan_Ngo.services.DateService;

@SpringBootTest
public class DateValidationTest {

    @Autowired
    private DateService dateService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    
    
    @Test
    // Testing DateService.getDate(String ...)
    public void test0() {
        String input = "05/20/12";
        List<String> result = dateService.getDates(input);
        
        assertEquals(1, result.size());
        assertEquals("2012-05-20", result.get(0));
    }

    @Test
    // Testing DateService.getDate(String ...)
    public void test1() {
        String input = "5/20/12";
        List<String> result = dateService.getDates(input);
        
        assertEquals(1, result.size());
        assertEquals("2012-05-20", result.get(0));
    }

    @Test
    // Testing DateService.getDate(String ...)
    public void test2() {
        String input = "13/4/30";
        List<String> result = dateService.getDates(input);
        
        assertEquals(0, result.size());
    }

    @Test
    // Testing DateService.getDate(String ...)
    public void test3() {
        String input = "December 5, 2000";
        List<String> result = dateService.getDates(input);
        
        assertEquals(1, result.size());
        assertEquals("2000-12-05", result.get(0));
    }

    @Test
   // Testing DateService.getDate(String ...)
    public void test4() {
        String input = "December 35, 2000";
        List<String> result = dateService.getDates(input);
        
        assertEquals(0, result.size());
    }

    @Test
    // Testing DateService.getDate(String ...)
    public void test5() {
        String input = "May-11-2013";
        List<String> result = dateService.getDates(input);
        
        assertEquals(1, result.size());
        assertEquals("2013-05-11", result.get(0));
    }

    @Test
    // Testing DateService.getDate(String ...)
    public void test6() {
        String input = "May-32-2020";
        List<String> result = dateService.getDates(input);
        
        assertEquals(0, result.size());
    }
}
