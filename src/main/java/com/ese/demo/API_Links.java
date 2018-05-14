package com.ese.demo;

// Class for accessing links to the marvel api
public class API_Links {

    //link for searching by character name
    private String URL_UPPER = System.getenv("urlUpper");
    private String URL_LOWER = System.getenv("urlLower");

    //link for searching comics by character id
    private String ID_URL_UPPER = System.getenv("idUrlUpper");
    private String ID_URL_LOWER = System.getenv("idUrlLower");

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
