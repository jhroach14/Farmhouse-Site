package com.webu.urban.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    void init();
    Path store(MultipartFile file);
    Path load(String filename);
    Resource loadAsResource(String filename);
    boolean deletePhoto(String filename);

}
