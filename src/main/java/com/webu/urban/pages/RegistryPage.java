package com.webu.urban.pages;

import com.webu.urban.entities.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class RegistryPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String intro_text;
    private Photo main_photo;

    public RegistryPage(){
        super("Registry", "/registry");
    }

    public RegistryPage(String title, String intro_text, Photo main_photo) {
        super(title, "/registry");
        this.intro_text = intro_text;
        this.main_photo = main_photo;
        log.debug("creating registry page data model...");
    }

    public String getIntro_text() {
        return intro_text;
    }

    public void setIntro_text(String intro_text) {
        this.intro_text = intro_text;
    }

    public Photo getMain_photo() {
        return main_photo;
    }

    public void setMain_photo(Photo main_photo) {
        this.main_photo = main_photo;
    }
}
