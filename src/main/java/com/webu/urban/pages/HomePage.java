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
    private Iterable<BlogPost> posts;

    public HomePage(){
        super("Home", "/home");
    }

    public HomePage(String title, Iterable<Photo> photos, Iterable<BlogPost> posts) {
        super(title, "/home");
        this.photos = photos;
        this.posts = posts;
        log.debug("creating home page data model...");
    }

    public Iterable<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Iterable<Photo> photos) {
        this.photos = photos;
    }

    public Iterable<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(Iterable<BlogPost> posts) {
        this.posts = posts;
    }
}
