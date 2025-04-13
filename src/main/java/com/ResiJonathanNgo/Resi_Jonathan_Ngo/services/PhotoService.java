package com.ResiJonathanNgo.Resi_Jonathan_Ngo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.PhotoList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.RoverList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.client.NasaMarsClient;

@Service
public class PhotoService {
    
    private static final String IMAGE_CACHE_PATH = "/tmp/";
    private final NasaMarsClient nasaMarsClient;

    public PhotoService(NasaMarsClient nasaMarsClient) {
        this.nasaMarsClient = nasaMarsClient;
    }

    public RoverList getRovers() {
        return nasaMarsClient.getRovers();
    }

    public PhotoList getPhotosList(String name, String date) {
        return nasaMarsClient.getPhotosList(name, date);
    }

    public Path getPhoto(String url) throws IOException {
        // Code referenced from nasa-exercise example provided
        final String sha = DigestUtils.sha512Hex(url);
		final String imageFileName = new StringBuilder(IMAGE_CACHE_PATH).append(sha).toString();
        
        byte[] photo = nasaMarsClient.getPhoto(url);
        Path filePath = Paths.get(IMAGE_CACHE_PATH + imageFileName);

        // Check if parent exists before writing file
        Path parent = filePath.getParent();

        if (!Files.exists(parent)) {
            Files.createDirectories(parent); 
        }

        Files.write(filePath, photo);
        return filePath;
    }
}
