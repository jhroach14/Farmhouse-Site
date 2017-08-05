package com.webu.urban.pages;

import com.webu.urban.entities.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class AboutPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String store_hours;
    private String company_bio;
    private Photo primary_photo;
    private Photo secondary_photo;

    public AboutPage(String title, String store_hours, String company_bio, Photo primary_photo, Photo secondary_photo) {
        super(title, "/about");
        this.store_hours = store_hours;
        this.company_bio = company_bio;
        this.primary_photo = primary_photo;
        this.secondary_photo = secondary_photo;
        log.debug("creating about page data model...");
    }

    public String getStore_hours() {
        return store_hours;
    }

    public void setStore_hours(String store_hours) {
        this.store_hours = store_hours;
    }

    public String getCompany_bio() {
        return company_bio;
    }

    public void setCompany_bio(String company_bio) {
        this.company_bio = company_bio;
    }

    public Photo getPrimary_photo() {
        return primary_photo;
    }

    public void setPrimary_photo(Photo primary_photo) {
        this.primary_photo = primary_photo;
    }

    public Photo getSecondary_photo() {
        return secondary_photo;
    }

    public void setSecondary_photo(Photo secondary_photo) {
        this.secondary_photo = secondary_photo;
    }
}
