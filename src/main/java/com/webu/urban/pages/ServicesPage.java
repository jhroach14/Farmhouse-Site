package com.webu.urban.pages;

import com.webu.urban.entities.Interior;
import com.webu.urban.entities.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by User on 1/10/2017.
 */
public class ServicesPage extends Page {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<Service> services;
    private Iterable<Interior> interiors;

    public ServicesPage(){
        super("Services", "/services");
    }

    public ServicesPage(String title, Iterable<Service> services, Iterable<Interior> interiors) {
        super(title, "/services");
        this.services = services;
        this.interiors = interiors;
        log.debug("creating services page data model...");
    }

    public Iterable<Service> getServices() {
        return services;
    }

    public void setServices(Iterable<Service> services) {
        this.services = services;
    }

    public Iterable<Interior> getInteriors() {
        return interiors;
    }

    public void setInteriors(Iterable<Interior> interiors) {
        this.interiors = interiors;
    }
}
