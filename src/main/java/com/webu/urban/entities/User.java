package com.webu.urban.entities;

import javax.persistence.*;

@Entity(name = "users")
public class User extends AbstractEntity{

    private String username;
    private boolean enabled;
    private String email;

    public User() {
    }

    public User(String username, boolean enabled, String email) {
        this.username = username;
        this.enabled = enabled;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof User) && (super.equals(o)));
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getEmail() {
        return email;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}