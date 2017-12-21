package com.webu.urban.pages;

import com.webu.urban.entities.GallerySection;
import com.webu.urban.entities.GallerySectionGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class GalleryPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<GallerySectionGroup> groups;

    public GalleryPage(){
        super("Gallery", "/gallery", "");
    }

    public GalleryPage(String title,  Iterable<GallerySectionGroup> groups,String permissions) {
        super(title, "/gallery",permissions);
        this.groups = groups;

        log.debug("creating gallery page data model...");
    }

    public Iterable<GallerySectionGroup> getGroups() {
        return groups;
    }

    public void setGroups(Iterable<GallerySectionGroup> groups) {
        this.groups = groups;
    }
}
