package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="about_pages")
public class AboutInfo extends AbstractEntity{

    private String store_hours;
    private String company_bio;
    @OneToOne
    @JoinColumn(name = "primary_photo")
    private Photo primary_photo;
    @OneToOne
    @JoinColumn(name="secondary_photo")
    private Photo secondary_photo;



    @Override
    public boolean equals(Object o) {
        return ((o instanceof AboutInfo) && super.equals(o));
    }


    public AboutInfo() {
    }

    public AboutInfo(String store_hours, String company_bio, Photo primary_photo, Photo secondary_photo) {
        this.store_hours = store_hours;
        this.company_bio = company_bio;
        this.primary_photo = primary_photo;
        this.secondary_photo = secondary_photo;
    }

    public void setStore_hours(String store_hours) {
        this.store_hours = store_hours;
    }

    public void setCompany_bio(String company_bio) {
        this.company_bio = company_bio;
    }

    public void setPrimary_photo(Photo primary_photo) {
        this.primary_photo = primary_photo;
    }

    public void setSecondary_photo(Photo secondary_photo) {
        this.secondary_photo = secondary_photo;
    }

    public String getStore_hours() {
        return store_hours;
    }

    public String getCompany_bio() {
        return company_bio;
    }

    public Photo getPrimary_photo() {
        return primary_photo;
    }

    public Photo getSecondary_photo() {
        return secondary_photo;
    }


}

