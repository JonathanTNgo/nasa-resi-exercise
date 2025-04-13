package com.ResiJonathanNgo.Resi_Jonathan_Ngo.client;

import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.PhotoList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.RoverList;

import reactor.netty.http.client.HttpClient;

@Component
public class NasaMarsClient {

    private final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers";
    private final String API_KEY = "7wzlvVZcOH3kNHz2gebneQmLDG3pVPcfzGssvLGu";
    private final String KEY_PARAM_NAME = "api_key";
    private final String DATE_PARAM_NAME = "earth_date";

    private final WebClient webClient = WebClient
        .builder()
        .clientConnector(new ReactorClientHttpConnector(
            HttpClient.create().followRedirect(true)
        ))
        .baseUrl(API_URL)
        .build();

    public RoverList getRovers() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .queryParam(KEY_PARAM_NAME, API_KEY)
                .build())
            .retrieve()
            .bodyToMono(RoverList.class)
            .block();
    }

    public PhotoList getPhotosList(String name, String date) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/" + name + "/photos")
                .queryParam(DATE_PARAM_NAME, date)
                .queryParam(KEY_PARAM_NAME, API_KEY)
                .build())
            .retrieve()
            .bodyToMono(PhotoList.class)
            .block();
    }

    public byte[] getPhoto(String url) {
        return webClient.get()
            .uri(url)
            .accept(MediaType.ALL)
            .retrieve()
            .bodyToMono(byte[].class)
            .block();
    }
}