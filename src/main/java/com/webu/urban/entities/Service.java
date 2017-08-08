package com.webu.urban.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="services")
public class Service extends AbstractEntity{

    private String service_title;
    private String service_text;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "service_photos", joinColumns = @JoinColumn(name = "service_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private List<Photo> photos;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Service) && super.equals(o));
    }

    public Service() {
    }

    public Service(String service_title, String service_text, Integer sequence_num,List<Photo> photos) {
        this.service_title = service_title;
        this.service_text = service_text;
        this.photos = photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public String getService_title() {
        return service_title;
    }

    public void setService_title(String service_title) {
        this.service_title = service_title;
    }

    public String getService_text() {
        return service_text;
    }

    public void setService_text(String service_text) {
        this.service_text = service_text;
    }

}
