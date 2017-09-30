package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="inspire_pages")
public class InspireInfo extends AbstractEntity{

    private String side_title;
    private String side_text;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof InspireInfo) && super.equals(o));
    }


    public InspireInfo() {
    }

    public InspireInfo(String side_title, String side_text) {
        this.side_title = side_title;
        this.side_text = side_text;
    }

    public String getSide_title() {
        return side_title;
    }

    public void setSide_title(String side_title) {
        this.side_title = side_title;
    }

    public String getSide_text() {
        return side_text;
    }

    public void setSide_text(String side_text) {
        this.side_text = side_text;
    }
}

