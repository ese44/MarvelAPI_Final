package com.ese.demo;

// Class for accessing links to the marvel api
public class API_Links {

    //link for searching by character name
    private String URL_UPPER = "http://gateway.marvel.com/v1/public/characters?name=";
    private String URL_LOWER = "&orderBy=name&ts=1&apikey=b6168abc18f41d92a4032fd954126073&hash=2d26ade77e6a23a22efa12c748635dca";

    //link for searching comics by character id
    private String ID_URL_UPPER = "https://gateway.marvel.com/v1/public/characters/";
    private String ID_URL_LOWER = "/comics?limit=10&ts=1&apikey=b6168abc18f41d92a4032fd954126073&hash=2d26ade77e6a23a22efa12c748635dca";

    // constructor
    public API_Links() {}

    //getters and setters

    public String getURL_UPPER() {
        return URL_UPPER;
    }

    public String getURL_LOWER() {
        return URL_LOWER;
    }

    public String getID_URL_UPPER() {
        return ID_URL_UPPER;
    }

    public String getID_URL_LOWER() {
        return ID_URL_LOWER;
    }
}
