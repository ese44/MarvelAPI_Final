package com.ese.demo.ComicDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreatorList {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("creators")
    @Expose
    private List<Creator> creators = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public CreatorList() {
    }


    public CreatorList(Integer available, String collectionURI, List<Creator> creators, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.creators = creators;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public CreatorList withAvailable(Integer available) {
        this.available = available;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public CreatorList withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    public CreatorList withItems(List<Creator> creators) {
        this.creators = creators;
        return this;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public CreatorList withReturned(Integer returned) {
        this.returned = returned;
        return this;
    }

}
