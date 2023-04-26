package com.example.dreamteam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthorModel {
    private String authorID;

    public AuthorModel(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() throws Exception {
        String url = "https://api.scholar.google.com/citations?user=" + authorID;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        // int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response = new StringBuffer();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();

        String authorName = response.toString().split("<title>", 2)[1].split("</title>", 2)[0].split(" - Google Scholar Citations", 2)[0];

        return authorName;
    }
}
