package com.webu.urban.entities;

import javax.persistence.Entity;

@Entity(name = "photos")
public class Photo extends AbstractEntity {

    private String photo_path; //path used instead of actual data bc db is for storing structured data not blob data
    private String photo_text; //mouseover text
    private String thumb_path;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Photo) && super.equals(o));
    }

    public Photo() {
    }

    public Photo(String photo_path, String photo_text, String thumb_path) {
        this.photo_path = photo_path;
        this.photo_text = photo_text;
        this.thumb_path = thumb_path;
    }

    public String getThumb_path() {
        return thumb_path;
    }

    public void setThumb_path(String thumb_path) {
        this.thumb_path = thumb_path;
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