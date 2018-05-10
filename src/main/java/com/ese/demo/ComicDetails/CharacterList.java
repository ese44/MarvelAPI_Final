package com.ese.demo.ComicDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterList {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("character")
    @Expose
    private List<Character> character = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public CharacterList() {
    }


    public CharacterList(Integer available, String collectionURI, List<Character> characters, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.character = characters;
        this.returned = returned;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public CharacterList withAvailable(Integer available) {
        this.available = available;
        return this;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public CharacterList withCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    public List<Character> getCharacter() {
        return character;
    }

    public void setCharacter(List<Character> character) {
        this.character = character;
    }

    public CharacterList withItems(List<Character> characters) {
        this.character = characters;
        return this;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public CharacterList withReturned(Integer returned) {
        this.returned = returned;
        return this;
    }

}
