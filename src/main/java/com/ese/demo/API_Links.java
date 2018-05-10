package com.ese.demo;

public class API_Links {

    private String URL_UPPER = "http://gateway.marvel.com/v1/public/characters?name=";
    private String URL_LOWER = "&orderBy=name&ts=1&apikey=b6168abc18f41d92a4032fd954126073&hash=2d26ade77e6a23a22efa12c748635dca";

    private String ID_URL_UPPER = "https://gateway.marvel.com/v1/public/characters/";
    private String ID_URL_LOWER = "/comics?limit=10&ts=1&apikey=b6168abc18f41d92a4032fd954126073&hash=2d26ade77e6a23a22efa12c748635dca";

    public API_Links() {}

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
