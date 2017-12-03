package com.webu.urban.pages;

import com.webu.urban.entities.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class AboutPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private String store_season;
    private String store_days;
    private String store_hours;
    private String company_bio;
    private String phone_number;
    private String address;
    private String email;
    private Photo primary_photo;
    private Photo secondary_photo;

    public AboutPage(){
        super("About", "/about","");
    }

    public AboutPage(String title,String store_season,String store_days, String store_hours, String company_bio,String phone_number, String address, String email, Photo primary_photo, Photo secondary_photo, String permissions) {
        super(title, "/about", permissions);
        this.store_season = store_season;
        this.store_days = store_days;
        this.store_hours = store_hours;
        this.company_bio = company_bio;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.primary_photo = primary_photo;
        this.secondary_photo = secondary_photo;
        log.debug("creating about page data model...");
    }

    public String getStore_season() {
        return store_season;
    }

    public void setStore_season(String store_season) {
        this.store_season = store_season;
    }

    public String getStore_days() {
        return store_days;
    }

    public void setStore_days(String store_days) {
        this.store_days = store_days;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
