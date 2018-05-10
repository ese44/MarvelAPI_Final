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

@Controller
public class FormController {

    API_Links Links = new API_Links();
    private Marvel initialData = findChar("spider-man");

    private UserSearch finalInput;
    private Marvel marvelChar;


    @RequestMapping("/")
    public ModelAndView addSearch(Model model) {

        String attributionText = initialData.getAttributionText();

        model.addAttribute("attribution",attributionText);

        return new ModelAndView("index.html", "search", new UserSearch());
    }


    @RequestMapping(value = "/addSearch", method = RequestMethod.POST)
    public RedirectView addNewSearch(UserSearch userSearch) {

        finalInput = userSearch;

        String selectView = verifySearch(userSearch.getSearchTerm());

        return new RedirectView(selectView);
    }


    @RequestMapping("/search")
    public ModelAndView search(ModelMap modelMap) {

        MarvelCharacter marvin = charGen();

        String attributionText = initialData.getAttributionText();

        modelMap.addAttribute("attribution",attributionText);


        modelMap.addAttribute("book", marvin.getBooks());
        modelMap.addAttribute("link", marvin.getLinks());


        modelMap.addAttribute("userEnteredSearch", marvin);
        return new ModelAndView("search.html", modelMap);
    }




    @RequestMapping("/fail")
    public String fail(Model model){
        return "fail.html";
    }


    private String verifySearch(String userSearch) {

        if (userSearch.equals("") || userSearch.equals(" ")){return "/fail";}

        else {

            marvelChar = findChar(userSearch);

            if (marvelChar.getData().getResults().size() == 0){return "/fail";}
            else {return "/search";}

        }
    }








    private Marvel findChar(String userSearch) {

        if (userSearch.contains(" ")){ userSearch = userSearch.replace(" ", "%20");}

        String url = Links.getURL_UPPER() + userSearch + Links.getURL_LOWER();

        Marvel marvelResult = accessMarvel(url);

        return marvelResult;
    }



    private Marvel accessMarvel(String url) {

        try{
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            Gson gson = new Gson();

            Marvel searchResults = gson.fromJson(response.getBody().toString(), Marvel.class);

            return searchResults;


        }catch (Exception j){return new Marvel();}
    }


    private MarvelCharacter charGen() {

        String imgSize = "/standard_fantastic.jpg";

        String charId = marvelChar.getData().getResults().get(0).getId().toString();
        String charName = marvelChar.getData().getResults().get(0).getName();
        String charDiscription = marvelChar.getData().getResults().get(0).getDescription();
        String charImage = marvelChar.getData().getResults().get(0).getThumbnail().getPath() + imgSize;
        ArrayList<String> moreInfo = linksListGen();

        ComicDetails marvinBooks = accessBooks(charId);

        ArrayList<String> bookImages = bookListGen(marvinBooks);


        MarvelCharacter marvin = new MarvelCharacter(charName, charDiscription, charImage, bookImages, moreInfo);

        return marvin;
    }

    private ComicDetails accessBooks(String charID) {

        String url = Links.getID_URL_UPPER() + charID + Links.getID_URL_LOWER();

        try{
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            Gson gson = new Gson();

            ComicDetails bookResults = gson.fromJson(response.getBody().toString(), ComicDetails.class);

            return bookResults;


        }catch (Exception j){return new ComicDetails();}
    }


    private ArrayList<String> bookListGen(ComicDetails books) {

        String imgSize = "/portrait_xlarge.jpg";

        ArrayList<String> bookList = new ArrayList<String>();

        for(int i = 0 ; i < books.getData().getResults().size() ; i++){

            String path = books.getData().getResults().get(i).getThumbnail().getPath();
            if (!path.contains("image_not_available")){bookList.add(path + imgSize);}

        }

        return bookList;
    }


    private ArrayList<String> linksListGen() {
        ArrayList<String> moreLinks = new ArrayList<String>();

        for (int i = 0 ; i < marvelChar.getData().getResults().get(0).getUrls().size() ; i++){

            String link = marvelChar.getData().getResults().get(0).getUrls().get(i).getUrl().toString();

            moreLinks.add(link);
        }

        return moreLinks;
    }

}
