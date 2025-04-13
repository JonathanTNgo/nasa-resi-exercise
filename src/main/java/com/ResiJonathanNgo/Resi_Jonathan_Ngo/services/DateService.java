package com.ResiJonathanNgo.Resi_Jonathan_Ngo.services;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DateService {
    
    private final Logger logger = LoggerFactory.getLogger(DateService.class);
    private List<String> dateList = new ArrayList<String>();

    public DateService() {
    }

    public List<String> getDates() {
        return dateList;
    }

    public List<String> getDates(String body) {
        // Create stream
		try (InputStream inputStream = new ByteArrayInputStream(body.getBytes());
        Stream<String> stream = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
    
            return dateValidate(stream);
            
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @PostConstruct
    private void initalizeDates() {
        final String FILENAME = "/imageDates.txt";
		
        // Create stream
		try (InputStream inputStream = getClass().getResourceAsStream(FILENAME);
				Stream<String> stream = new BufferedReader(new InputStreamReader(inputStream)).lines()) {
			
            // Validate dates in stream
            dateList = dateValidate(stream);
			
		} catch (Exception e) {
			logger.error("Error reading file {}", FILENAME, e.getStackTrace());
		}

    }

    // Following date validation is from nasa-exercise example
    private List<String> dateValidate(Stream<String> stream) {
        final String[] POSSIBLEFORMATS = {
            "MM/dd/yy",
            "MMM d, yyyy",
            "MMM-d-yyyy"
        };

        List<String> dates = new ArrayList<>();
        
        stream.forEach(date -> {
            try {
                logger.trace("Raw date from file: {}", date);
                Date parsedDate = DateUtils.parseDateStrictly(date, POSSIBLEFORMATS);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                dates.add(formatter.format(parsedDate));
            } catch (ParseException e) {
                logger.error("{} is an invalid date.", date, e.getMessage());
            }
        });

        return dates;
    }
}
