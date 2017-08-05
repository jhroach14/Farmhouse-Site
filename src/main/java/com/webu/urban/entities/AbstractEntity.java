package com.webu.urban.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by User on 8/5/2017.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Override//following two methods allows for use in a set, which is used for non duplicate entity lists
    public boolean equals(Object o) {
        return (((AbstractEntity) o).getId()).equals(this.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
