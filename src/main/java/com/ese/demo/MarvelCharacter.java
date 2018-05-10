package com.ese.demo;

import java.util.ArrayList;

public class MarvelCharacter {

    private String name;
    private String description;
    private String image;
    private ArrayList<String> books;
    private ArrayList<String> links;


    MarvelCharacter(){}

    public MarvelCharacter(String name, String description, String image, ArrayList<String> books, ArrayList<String> links) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.books = books;
        this.links = links;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<String> links) {
        this.links = links;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
