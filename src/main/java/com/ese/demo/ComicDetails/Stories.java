package com.ese.demo.ComicDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stories {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("stories")
    @Expose
    private List<Story> stories = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public Stories() {
    }


    public Stories(Integer available, String collectionURI, List<Story> stories, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.stories = stories;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Stories withAvailable(Integer available) {
        this.available = available;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public Stories withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Stories withItems(List<Story> stories) {
        this.stories = stories;
        return this;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public Stories withReturned(Integer returned) {
        this.returned = returned;
        return this;
    }

}
