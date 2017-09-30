package com.webu.urban.pages;

import com.webu.urban.entities.BlogPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jo809 on 8/5/2017.
 */
public class InspirePage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<BlogPost> posts;

    public InspirePage(){
        super("Inspire", "/inspire");
    }
}
