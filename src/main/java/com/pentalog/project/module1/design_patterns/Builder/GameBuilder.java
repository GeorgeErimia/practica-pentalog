package com.pentalog.project.module1.design_patterns.Builder;

import com.pentalog.project.module1.tema2.MOBAGame;
import com.pentalog.project.module1.tema2.RPGGame;
import com.pentalog.project.module1.tema2.ShooterGame;

import java.util.ArrayList;
import java.util.List;

// Game Builder class wich can build any type of game
public class GameBuilder {
    private String name;
    private String releaseDate;
    private List<String> platforms;
    private double price;
    private int maxPlayers;
    private int nrOfClasses;
    private int nrOfHeroes;
    private int nrOfMaps;

    public GameBuilder() {
        reset();
    }

    public void reset() {
        this.name = "NONE";
        this.releaseDate = "NONE";
        this.platforms = new ArrayList<>();
        this.price = 0.0;
        this.maxPlayers = 0;
        this.nrOfClasses = 0;
        this.nrOfHeroes = 0;
        this.nrOfMaps = 0;
    }

    // GETTERS
    public ShooterGame getShooterGame() {
        return new ShooterGame(name, releaseDate, price, maxPlayers, nrOfClasses);
    }

    public RPGGame getRPGGame() {
        return new RPGGame(name, releaseDate, price, maxPlayers);
    }

    public MOBAGame getMOBAGame() {
        return new MOBAGame(name, releaseDate, price, maxPlayers, nrOfHeroes, nrOfMaps);
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setNrOfClasses(int nrOfClasses) {
        this.nrOfClasses = nrOfClasses;
    }

    public void setNrOfHeroes(int nrOfHeroes) {
        this.nrOfHeroes = nrOfHeroes;
    }

    public void setNrOfMaps(int nrOfMaps) {
        this.nrOfMaps = nrOfMaps;
    }


}
