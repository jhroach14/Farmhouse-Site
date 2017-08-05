package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "registry_pages")
public class RegistryInfo extends AbstractEntity{

    private String intro_text;
    @OneToOne
    @JoinColumn(name = "main_photo")
    private Photo main_photo;




    @Override
    public boolean equals(Object o) {
        return ((o instanceof RegistryInfo) && super.equals(o));
    }


    public RegistryInfo() {
    }

    public RegistryInfo(String intro_text, Photo main_photo) {
        this.intro_text = intro_text;
        this.main_photo = main_photo;
    }

    public String getIntro_text() {
        return intro_text;
    }

    public void setIntro_text(String intro_text) {
        this.intro_text = intro_text;
    }

    public void setMain_photo(Photo main_photo) {
        this.main_photo = main_photo;
    }

    public Photo getMain_photo() {
        return main_photo;
    }
}
