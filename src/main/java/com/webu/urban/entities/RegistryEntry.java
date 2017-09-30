package com.webu.urban.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "registry_entry")
public class RegistryEntry extends AbstractEntity{

    private String recipient;
    private String code;
    private String description;
    private String email;
    private String phone;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "entry_items", joinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<RegistryItem> items;

    @Override
    public boolean equals(Object o) {
        return ((o instanceof RegistryEntry) && super.equals(o));
    }

    public RegistryEntry() {
    }

    public RegistryEntry(String recipient, String code, String description, String email, String phone, List<RegistryItem> items) {
        this.recipient = recipient;
        this.code = code;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<RegistryItem> getItems() {
        return items;
    }

    public void setItems(List<RegistryItem> items) {
        this.items = items;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
