package com.pentalog.project.module1.tema2;

import java.util.List;

public abstract class Game{
    protected String name;
    protected String releaseDate;
    protected List<String> platforms;
    private double price;

    // CONSTRUCTOR
    public Game(String name, String releaseDate, double price){
        this.name = name;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    // GETTERS
    public String getName() { return this.name; }

    public String getReleaseDate() { return this.releaseDate; }

    public List<String> getPlatforms() { return this.platforms; }

    // SETTERS
    public void setName(String name) { this.name = name; }

    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public void setPlatforms(List<String> platforms) { this.platforms = platforms; }

    // MEHTODS
    public String getBasicInfo(){
        StringBuilder str = new StringBuilder("");
        str.append("\r\nName: " + this.name + "\r\n");
        str.append("Price: " + this.price + "\r\n");
        return str.toString();
    }
}
