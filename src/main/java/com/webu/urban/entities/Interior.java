package com.webu.urban.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "interiors")
public class Interior extends AbstractEntity{

    private Integer sequence_num;
    private String address;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "interior_photos", joinColumns = @JoinColumn(name = "interior_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id"))
    private List<Photo> photos;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof Interior) && super.equals(o));
    }

    public Interior(Integer sequence_num, String address, List<Photo> photos) {
        this.sequence_num = sequence_num;
        this.address = address;
        this.photos = photos;
    }

    public Interior() {
    }

    public Integer getSequence_num() {
        return sequence_num;
    }

    public void setSequence_num(Integer sequence_num) {
        this.sequence_num = sequence_num;
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
