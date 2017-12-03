package com.webu.urban.pages;

import com.webu.urban.entities.Event;
import com.webu.urban.entities.Interior;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventsPage extends Page{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Iterable<Event> events;

    public EventsPage(String title, Iterable<Event> events, String permissions) {
        super(title, "/events",permissions);
        this.events = events;
    }

    public Iterable<Event> getEvents() {
        return events;
    }

    public void setEvents(Iterable<Event> events) {
        this.events = events;
    }
}
