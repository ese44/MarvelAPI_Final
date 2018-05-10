package com.ese.demo.ComicDetails;

import com.ese.demo.Marvels.Event;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventList {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("events")
    @Expose
    private List<Event> events = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public EventList() {
    }


    public EventList(Integer available, String collectionURI, List<Event> events, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.events = events;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public EventList withAvailable(Integer available) {
        this.available = available;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public EventList withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public EventList withItems(List<Event> items) {
        this.events = items;
        return this;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public EventList withReturned(Integer returned) {
        this.returned = returned;
        return this;
    }

}
