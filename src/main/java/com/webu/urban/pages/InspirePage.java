package com.webu.urban.pages;

import com.webu.urban.entities.BlogPost;
import com.webu.urban.entities.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jo809 on 8/5/2017.
 */
public class InspirePage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<BlogPost> posts;
    private String side_title;
    private String side_text;

    public InspirePage(){

        super("Inspire", "/inspire","");
    }

    public InspirePage(String title, Iterable<BlogPost> posts, String side_title, String side_text,String permissions) {
        super(title, "/inspire",permissions);
        this.posts = posts;
        this.side_title = side_title;
        this.side_text = side_text;
    }

    public Iterable<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(Iterable<BlogPost> posts) {
        this.posts = posts;
    }

    public String getSide_title() {
        return side_title;
    }

    public void setSide_title(String side_title) {
        this.side_title = side_title;
    }

    public String getSide_text() {
        return side_text;
    }

    public void setSide_text(String side_text) {
        this.side_text = side_text;
    }
}
