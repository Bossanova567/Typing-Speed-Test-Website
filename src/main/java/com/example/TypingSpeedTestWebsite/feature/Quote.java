package com.example.TypingSpeedTestWebsite.feature;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.net.URL;

public class Quote {

    public String generateQuote()  {
        String quote = "";
        try {
            JSONParser parser = new JSONParser();
            String url = "https://favqs.com/api/qotd";
            JSONObject rootJsonObject = (JSONObject) parser.parse(new InputStreamReader(new URL(url).openStream()));
            JSONObject body = (JSONObject) rootJsonObject.get("quote");
            quote = (String) body.get("body");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return quote;
    }

}
