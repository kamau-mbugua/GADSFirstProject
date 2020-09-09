package com.example.gadsproject;

public class Listitem {
    private  String name;
    private String country;
    private String score;
    private String image;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getScore() {
        return score;
    }

    public String getImage() {
        return image;
    }

    public Listitem(String name, String country, String score, String image) {
        this.name = name;
        this.country = country;
        this.score = score;
        this.image = image;

    }
}
