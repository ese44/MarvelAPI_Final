package com.ese.demo;


import com.ese.demo.ComicDetails.ComicDetails;
import com.ese.demo.Marvels.Marvel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class for controlling calls to the server
@Controller
public class FormController {

    API_Links Links = new API_Links(); // create a link object to access the api links
    private Marvel initialData = findChar("spider-man"); // marvel data access api attribution

    private UserSearch finalInput; // user search object
    private Marvel marvelChar; // marvel object to hold character data


    // mapping control for the home page
    @RequestMapping("/")
    public ModelAndView addSearch(Model model) {

        String attributionText = initialData.getAttributionText();

        model.addAttribute("attribution",attributionText);

        return new ModelAndView("index.html", "search", new UserSearch());
    }

// mapping for the user entered search
    @RequestMapping(value = "/addSearch", method = RequestMethod.POST)
    public RedirectView addNewSearch(UserSearch userSearch) {

        finalInput = userSearch;

        String selectView = verifySearch(userSearch.getSearchTerm());

        return new RedirectView(selectView);
    }

// mapping for searching the api
    @RequestMapping("/search")
    public ModelAndView search(ModelMap modelMap) {

        MarvelCharacter marvin = charGen(); // call method to create the character object

        String attributionText = initialData.getAttributionText(); // get the required attribution text

        modelMap.addAttribute("attribution",attributionText); // add attribution to the modelmap


        modelMap.addAttribute("book", marvin.getBooks()); // add the list of books to the modelmap
        modelMap.addAttribute("link", marvin.getLinks()); // add the list of links to the modelmap


        modelMap.addAttribute("userEnteredSearch", marvin); // add the character object to the modelmap
        return new ModelAndView("search.html", modelMap); // display the character data
    }



    // mapping for displaying the failure page
    @RequestMapping("/fail")
    public String fail(Model model){
        return "fail.html";
    }


    private String verifySearch(String userSearch) {

        // input validation
        if (userSearch.equals("") || userSearch.equals(" ")){return "/fail";}

        else {

            marvelChar = findChar(userSearch); // call method to search the api

            if (marvelChar.getData().getResults().size() == 0){return "/fail";} // return empty character
            else {return "/search";}

        }
    }







// method for finding the specific character
    private Marvel findChar(String userSearch) {

        String split = "%20"; // replace spaces in the character name with this string

        if (userSearch.contains(" ")){ userSearch = userSearch.replace(" ", split);} // replace the spaces

        String url = Links.getURL_UPPER() + userSearch + Links.getURL_LOWER(); // for the search url

        Marvel marvelResult = accessMarvel(url); // call method to search the api with the specified url

        return marvelResult;
    }


// method for getting the json from the marvel api
    private Marvel accessMarvel(String url) {

        try{ // get request using unirest then changing it to a json object
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            Gson gson = new Gson(); // new gson object

            Marvel searchResults = gson.fromJson(response.getBody().toString(), Marvel.class); // use gson to convert the json object to a marvel object

            return searchResults; // return the marvel object


        }catch (Exception j){return new Marvel();}
    }


    // method for creating a marvel character object
    private MarvelCharacter charGen() {

        String imgSize = "/standard_fantastic.jpg"; // define the size of the image displayed

        // get the select data about the character
        String charId = marvelChar.getData().getResults().get(0).getId().toString();
        String charName = marvelChar.getData().getResults().get(0).getName();
        String charDiscription = marvelChar.getData().getResults().get(0).getDescription();
        String charImage = marvelChar.getData().getResults().get(0).getThumbnail().getPath() + imgSize;
        ArrayList<String> moreInfo = linksListGen();

        ComicDetails marvinBooks = accessBooks(charId); // method to get comic book data

        ArrayList<String> bookImages = bookListGen(marvinBooks); // add the images from the comics to an arraylist


        MarvelCharacter marvin = new MarvelCharacter(charName, charDiscription, charImage, bookImages, moreInfo); // crate the character object

        return marvin; // return the character
    }

    // methoding for getting comicbooks for the specific character
    private ComicDetails accessBooks(String charID) {

        String url = Links.getID_URL_UPPER() + charID + Links.getID_URL_LOWER();

        try{
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            Gson gson = new Gson();

            ComicDetails bookResults = gson.fromJson(response.getBody().toString(), ComicDetails.class);

            return bookResults;


        }catch (Exception j){return new ComicDetails();}
    }


    // method for creating the list of comicbooks
    private ArrayList<String> bookListGen(ComicDetails books) {

        String imgSize = "/portrait_xlarge.jpg";

        ArrayList<String> bookList = new ArrayList<String>();

        for(int i = 0 ; i < books.getData().getResults().size() ; i++){

            String path = books.getData().getResults().get(i).getThumbnail().getPath();
            if (!path.contains("image_not_available")){bookList.add(path + imgSize);}

        }

        return bookList;
    }

// method for getting the three links for more data
    private ArrayList<String> linksListGen() {
        ArrayList<String> moreLinks = new ArrayList<String>();

        for (int i = 0 ; i < marvelChar.getData().getResults().get(0).getUrls().size() ; i++){

            String link = marvelChar.getData().getResults().get(0).getUrls().get(i).getUrl().toString();

            moreLinks.add(link);
        }

        return moreLinks;
    }

}
