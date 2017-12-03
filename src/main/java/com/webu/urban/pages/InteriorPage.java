package com.webu.urban.pages;

import com.webu.urban.entities.Interior;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class InteriorPage extends Page{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<Interior> interiors;

    public InteriorPage(String title, Iterable<Interior> interiors,String permissions) {
        super(title, "/interiors",permissions);
        this.interiors = interiors;
    }

    public Iterable<Interior> getInteriors() {
        return interiors;
    }

    public void setInteriors(Iterable<Interior> interiors) {
        this.interiors = interiors;
    }
}
