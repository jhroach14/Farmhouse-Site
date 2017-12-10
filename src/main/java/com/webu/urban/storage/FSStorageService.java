package com.webu.urban.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FSStorageService implements StorageService {

    private final String rootLocation;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FSStorageService(StorageProperties properties) {

        this.rootLocation = properties.getLocation();
        log.debug("Initialized FSSS with root location "+ rootLocation);
    }



    @Override
    public void init() {
       /* try{
            //Files.createDirectories(rootLocation);
        }catch (IOException e){
            log.error("could not initialize storage");
            throw new StorageException("could not initialize storage",e);
        }*/
    }

    @Override
    public Path store(MultipartFile file) {

        String sanitized = file.getOriginalFilename().replaceAll("[^a-zA-Z0-9\\._]+", "_");
        log.debug("attempting to store image with filename "+sanitized);
        try{

            if(file.isEmpty()){
                throw new StorageException("Failed to store empty file "+ sanitized);
            }
            if(sanitized.contains("..")){
                throw new StorageException("relative path not allowed in filename +"+sanitized);
            }

            byte[] bytes = file.getBytes();

            Path path = Paths.get(URI.create(this.rootLocation + sanitized));
            log.debug("attempting to store image to "+path.toString());
            Files.write(path,bytes);

            //Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){
            log.error("Failed to store file "+sanitized+"\n"+e.getMessage());
            throw new StorageException("Failed to store file "+sanitized, e);
        }
        log.debug("Successfully stored image at " +this.rootLocation +sanitized);
        return Paths.get(URI.create(this.rootLocation + sanitized));

    }

    @Override
    public Path load(String filename) {
        String sanitized = filename.replaceAll("[^a-zA-Z0-9\\._]+", "_");

        log.debug("loading image with name "+sanitized+" from location "+rootLocation +sanitized);
        return Paths.get(rootLocation+sanitized);
    }

    @Override
    public Resource loadAsResource(String filename) {

        filename = filename.replaceAll("[^a-zA-Z0-9\\._]+", "_");

        try{
            log.debug("attmpting to load img as resource "+filename);
            Path file = load(filename);

            URI uri = new URI(file.toString());
            Resource resource = new UrlResource(uri);
            if(resource.exists()||resource.isReadable()){
                log.debug("Resource img "+filename+" successfully loaded");
                return resource;
            }else{
                log.error("Could not read file "+filename);
                throw new StorageFileNotFoundException("Could not read file "+filename);
            }
        }catch (Exception e){
            log.error("Could not read file "+filename+"\n"+e.getMessage());
            throw new StorageFileNotFoundException("Could not read file "+ filename, e);
        }

    }

    @Override
    public boolean deletePhoto(String filename) {

        filename = filename.replaceAll("[^a-zA-Z0-9\\._]+", "_");
        Path file = load(filename);
        boolean deleted = false;
        try {
            log.debug("Attempting to delete file at path "+file.toString());
            Files.delete(file);
            log.debug("File named  "+filename+" deleted");
            deleted = true;
        } catch (IOException e) {
            log.error("Error deleting file "+ filename+"\n"+e.getMessage());
        }

        return deleted;
    }

}
