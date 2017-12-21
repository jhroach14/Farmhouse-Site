package com.webu.urban.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "interiors")
public class Interior extends AbstractEntity{

    private String address;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "interior_photos", joinColumns = @JoinColumn(name = "interior_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private List<Photo> photos;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Interior) && super.equals(o));
    }

    public Interior(String address, List<Photo> photos) {
        this.address = address;
        this.photos = photos;
    }

    public Interior() {
        this.address = "";
        ArrayList<Photo> photosEmpty = new ArrayList<>();
        this.photos = photosEmpty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }
}
