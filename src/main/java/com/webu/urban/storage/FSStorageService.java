package com.webu.urban.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.management.FileSystem;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        log.debug("attempting to store image with filename "+filename);
        try{

            if(file.isEmpty()){
                throw new StorageException("Failed to store empty file "+ filename);
            }
            if(filename.contains("..")){
                throw new StorageException("relative path not allowed in filename +"+filename);
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(URI.create(this.rootLocation + file.getOriginalFilename()));
            log.debug("attempting to store image to "+path.toString());
            Files.write(path,bytes);

            //Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){
            log.error("Failed to store file "+filename+"\n"+e.getMessage());
            throw new StorageException("Failed to store file "+filename, e);
        }
        log.debug("Successfully stored image at " +this.rootLocation +filename);
        return Paths.get(URI.create(this.rootLocation + file.getOriginalFilename()));

    }

    @Override
    public Path load(String filename) {
        log.debug("loading image with name "+filename+" from location "+rootLocation +filename);
        return Paths.get(rootLocation+filename);
    }

    @Override
    public Resource loadAsResource(String filename) {

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

}
