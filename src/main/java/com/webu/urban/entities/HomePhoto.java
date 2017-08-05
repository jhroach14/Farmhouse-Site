package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "home_page_photos")
public class HomePhoto extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "photo")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Photo) && super.equals(o));
    }

    public HomePhoto() {
    }

    public HomePhoto(Photo photo) {
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}