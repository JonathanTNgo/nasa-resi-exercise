package com.ResiJonathanNgo.Resi_Jonathan_Ngo.services;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.PhotoList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.beans.RoverList;
import com.ResiJonathanNgo.Resi_Jonathan_Ngo.client.NasaMarsClient;

@Service
public class PhotoService {
    
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

    // public File getPhoto(String url) {
    //     // Code referenced from nasa-exercise example provided
    //     InputStream inputStream = nasaMarsClient.getPhoto(url);
    //     Path path = Files.createFile(Paths.get(url));
    //     Files.createDirectories(path.getParent());
    //     Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);

    //     IOUtils.closeQuietly(inputStream);
    //     return path.toFile();
    // }
}
