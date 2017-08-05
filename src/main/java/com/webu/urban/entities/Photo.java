package com.webu.urban.entities;

import javax.persistence.Entity;

@Entity(name = "photos")
public class Photo extends AbstractEntity {

    private String photo_path; //path used instead of actual data bc db is for storing structured data not blob data
    private String photo_text; //mouseover text

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Photo) && super.equals(o));
    }

    public Photo() {
    }

    public Photo(String photo_path, String photo_text) {
        this.photo_path = photo_path;
        this.photo_text = photo_text;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public String getPhoto_text() {
        return photo_text;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public void setPhoto_text(String photo_text) {
        this.photo_text = photo_text;
    }
}