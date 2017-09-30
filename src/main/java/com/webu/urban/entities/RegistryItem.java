package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "registry_item")
public class RegistryItem extends AbstractEntity{

    private double price;
    private String description;
    private String title;

    @OneToOne
    @JoinColumn(name = "photo")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof RegistryItem) && super.equals(o));
    }

    public RegistryItem() {
    }

    public RegistryItem(double price, String description, Photo photo, String title) {
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
