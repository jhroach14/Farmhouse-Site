package com.webu.urban.pages;

import com.webu.urban.entities.BlogPost;
import com.webu.urban.entities.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class HomePage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<Photo> photos;

    public HomePage(){
        super("Home", "/home");
    }

    public HomePage(String title, String template, Iterable<Photo> photos) {
        super(title, template);
        this.photos = photos;
        log.debug("creating home page data model...");
    }

    public Iterable<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Iterable<Photo> photos) {
        this.photos = photos;
    }

}
