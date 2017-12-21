package com.webu.urban.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "gallery_section_group")
public class GallerySectionGroup  extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "section1")
    private GallerySection section1;
    @OneToOne
    @JoinColumn(name = "section2")
    private GallerySection section2;
    @OneToOne
    @JoinColumn(name = "section3")
    private GallerySection section3;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof GallerySectionGroup) && super.equals(o));
    }

    public GallerySectionGroup(GallerySection section1, GallerySection section2, GallerySection section3) {
        this.section1 = section1;
        this.section2 = section2;
        this.section3 = section3;
    }

    public GallerySectionGroup() {
    }

    public GallerySection getSection1() {
        return section1;
    }

    public void setSection1(GallerySection section1) {
        this.section1 = section1;
    }

    public GallerySection getSection2() {
        return section2;
    }

    public void setSection2(GallerySection section2) {
        this.section2 = section2;
    }

    public GallerySection getSection3() {
        return section3;
    }

    public void setSection3(GallerySection section3) {
        this.section3 = section3;
    }
}
