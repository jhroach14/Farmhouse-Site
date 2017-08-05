package com.webu.urban.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "gallery_sections")
public class GallerySection extends AbstractEntity{

    private String section_title;
    private String section_text;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "gallery_section_photos", joinColumns = @JoinColumn(name = "section_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private List<Photo> photos;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof GallerySection) && super.equals(o));
    }


    public GallerySection() {
    }

    public GallerySection(String section_title, String section_text, List<Photo> photos) {
        this.section_title = section_title;
        this.section_text = section_text;
        this.photos = photos;
    }

    public String getSection_title() {
        return section_title;
    }

    public void setSection_title(String section_title) {
        this.section_title = section_title;
    }

    public String getSection_text() {
        return section_text;
    }

    public void setSection_text(String section_text) {
        this.section_text = section_text;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

}
