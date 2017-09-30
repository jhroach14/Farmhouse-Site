package com.webu.urban.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="events")
public class Event extends AbstractEntity{

    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "photo")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Event) && super.equals(o));
    }

    public Event() {
    }

    public Event(String name, String description, Photo photo) {
        this.name = name;
        this.description = description;
        this.photo = photo;
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
