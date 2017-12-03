package com.webu.urban.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="events")
public class Event extends AbstractEntity{

    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "event_photos", joinColumns = @JoinColumn(name = "interior_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private List<Photo> photos;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Event) && super.equals(o));
    }

    public Event() {
    }

    public Event(String name, String description, List<Photo> photos) {
        this.name = name;
        this.description = description;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
