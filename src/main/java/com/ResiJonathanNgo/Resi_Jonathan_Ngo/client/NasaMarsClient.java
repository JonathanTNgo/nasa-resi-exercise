package com.ResiJonathanNgo.Resi_Jonathan_Ngo.client;

import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class NasaMarsClient {

    private final String API_URL = "https://api.nasa.gov/mars-photos/api/v1";
    private final String API_KEY = "7wzlvVZcOH3kNHz2gebneQmLDG3pVPcfzGssvLGu";
    private final String KEY_PARAM_NAME = "api_key";
    private final String DATE_PARAM_NAME = "earth_date";

    private final WebClient webClient = WebClient.create();

    public List<Rover> getRovers() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path(API_URL + "/rovers")
                .queryParam(KEY_PARAM_NAME, API_KEY)
                .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }

    // public List<Photo> getPhotosList(String name, String date) {
        
    // }

    // public InputStream getPhoto(String url) {
    //     InputStream stream = webClient.get().uri(url).retrieve().bodyToMono(InputStream.class).block();
    // }
}