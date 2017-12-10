package com.webu.urban.controllers;

import com.webu.urban.entities.Photo;
import com.webu.urban.entities.repositories.PhotoRepository;
import com.webu.urban.storage.StorageFileNotFoundException;
import com.webu.urban.storage.StorageService;
import com.webu.urban.storage.imageUtil.BufferedImageThumbnailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

@Controller
public class FileUploadController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PhotoRepository photoRepository;

    private final StorageService storageService;
    private final BufferedImageThumbnailer thumbnailer;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
        this.thumbnailer = new BufferedImageThumbnailer(150);
        log.debug("Initialized storage and thumbnail service");
    }

    @GetMapping("/img/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        log.debug("received request for img "+filename);
        Resource file = storageService.loadAsResource(filename);
        log.debug("img "+filename+" successfully retrieved. sending to client");
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "inline").body(file);
    }
    @GetMapping("/img/thumb/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveThumbFile(@PathVariable String filename) {
        log.debug("received request for thumb img "+filename);
        Resource file = storageService.loadAsResource("thumb/"+filename);
        log.debug(" thumb img "+filename+" successfully retrieved. sending to client");
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "inline").body(file);
    }


    @PostMapping("/admin/img/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        log.debug("Recieved new image to upload to filesystem "+file.getName());

        Path imgPath = storageService.store(file);
        String imgStr = imgPath.toString().substring(imgPath.toString().indexOf("/img/"));
        log.debug("New image stored to path "+imgStr);

        Path thumbPath = thumbnailer.thumbify(imgPath);
        String thumbStr = thumbPath.toString().substring(thumbPath.toString().indexOf("/img/"));
        log.debug("New Image thumbnail stored to path "+thumbStr);

        Photo photo = new Photo(imgStr,"",thumbStr);
        boolean exists = false;
        for (Photo photo1: photoRepository.findAll()) {
            if (photo1.getPhoto_path().equals(imgStr)){
                exists = true;
            }
        }
        if(!exists){

            photo = photoRepository.save(photo);
            log.debug("Photo saved to data base with id "+ photo.getId());
        }else {
            log.debug("Name match in photo database. Not modifying photo table to avoid duplicate db entries");
        }

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/admin/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }



}
