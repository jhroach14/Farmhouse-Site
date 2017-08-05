package com.webu.urban.pages;

import com.webu.urban.entities.GallerySection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class GalleryPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<GallerySection> sections;

    public GalleryPage(String title,  Iterable<GallerySection> sections) {
        super(title, "/gallery");
        this.sections = sections;
        log.debug("creating gallery page data model...");
    }

    public Iterable<GallerySection> getSections() {
        return sections;
    }

    public void setSections(Iterable<GallerySection> sections) {
        this.sections = sections;
    }
}
