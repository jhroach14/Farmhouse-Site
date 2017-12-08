package com.webu.urban.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "blog_posts")
public class BlogPost extends AbstractEntity{

    private String post_title;
    private String post_text;
    private Integer post_type;

    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date post_date;

    @OneToOne
    @JoinColumn(name = "photo")
    private Photo photo;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof BlogPost) && super.equals(o));
    }

    public BlogPost(String post_title, String post_text, Photo photo, Integer post_type, Date post_date) {
        this.post_title = post_title;
        this.post_text = post_text;
        this.photo = photo;
        this.post_type = post_type;
        this.post_date = post_date;
    }

    public BlogPost() {
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }



    public Integer getPost_type() {
        return post_type;
    }

    public void setPost_type(Integer post_type) {
        this.post_type = post_type;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }
}
