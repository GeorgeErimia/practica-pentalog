package com.pentalog.project.module1.tema2;

import com.pentalog.project.module1.design_patterns.Builder.GameBuilder;

import java.util.ArrayList;
import java.util.List;

public class GameDB {

    // SINGLETON PATTERN (game database needs only one instance)
    private static GameDB instance;
    List<Game> gameList;

    // Lazy Initialization
    public static GameDB getInstance(){
        if(instance == null)
            instance = new GameDB();
        return instance;
    }

    public List<ShooterGame> getShooterGames() {
        List<ShooterGame> shooterGames = new ArrayList<>();
        for (Game game : gameList) {
            if (game instanceof ShooterGame) {
                shooterGames.add((ShooterGame) game);
            }
        }
        return shooterGames;
    }

    public List<RPGGame> getRPGGames() {
        List<RPGGame> rpgGames = new ArrayList<>();
        for (Game game : gameList) {
            if (game instanceof RPGGame) {
                rpgGames.add((RPGGame) game);
            }
        }
        return rpgGames;
    }

    public List<MOBAGame> getMOBAGames() {
        List<MOBAGame> mobaGames = new ArrayList<>();
        for (Game game : gameList) {
            if (game instanceof MOBAGame) {
                mobaGames.add((MOBAGame) game);
            }
        }
        return mobaGames;
    }

    public List<Game> getGames() {
        return this.gameList;
    }

    private GameDB() {
        gameList = new ArrayList<>();
        addGames();
    }

    public void addGames() {
        GameBuilder gameBuilder = new GameBuilder();

        // Shooters
        gameBuilder.setName("Call of Duty");
        gameBuilder.setReleaseDate("29/10/2003");
        gameBuilder.setPrice(5.99);
        gameBuilder.setMaxPlayers(50);
        gameBuilder.setNrOfClasses(1);
        gameList.add(gameBuilder.getShooterGame());

        gameBuilder.reset();

        gameBuilder.setName("Battlefield 1942");
        gameBuilder.setReleaseDate("28/06/2004");
        gameBuilder.setPrice(9.98);
        gameBuilder.setMaxPlayers(50);
        gameBuilder.setNrOfClasses(5);
        gameList.add(gameBuilder.getShooterGame());

        gameBuilder.reset();

        gameBuilder.setName("Apex Legends");
        gameBuilder.setReleaseDate("04/02/2019");
        gameBuilder.setPrice(0.00);
        gameBuilder.setMaxPlayers(100);
        gameBuilder.setNrOfClasses(4);
        gameList.add(gameBuilder.getShooterGame());

        gameBuilder.reset();

        gameBuilder.setName("Diablo II");
        gameBuilder.setReleaseDate("29/06/2000");
        gameBuilder.setPrice(25.00);
        gameBuilder.setMaxPlayers(1);
        gameList.add(gameBuilder.getRPGGame());

        gameBuilder.reset();

        gameBuilder.setName("Fallout 4");
        gameBuilder.setReleaseDate("10/11/2015");
        gameBuilder.setPrice(21.48);
        gameBuilder.setMaxPlayers(1);
        gameList.add(gameBuilder.getRPGGame());

        gameBuilder.reset();

        gameBuilder.setName("Path of Exile");
        gameBuilder.setReleaseDate("23/10/2013");
        gameBuilder.setPrice(0.00);
        gameBuilder.setMaxPlayers(1);
        gameList.add(gameBuilder.getRPGGame());

        gameBuilder.reset();

        gameBuilder.setName("League of Legends");
        gameBuilder.setReleaseDate("27/10/2009");
        gameBuilder.setPrice(0.00);
        gameBuilder.setMaxPlayers(10);
        gameBuilder.setNrOfHeroes(159);
        gameBuilder.setNrOfMaps(2);
        gameList.add(gameBuilder.getMOBAGame());

        gameBuilder.reset();

        gameBuilder.setName("DOTA 2");
        gameBuilder.setReleaseDate("9/07/2013");
        gameBuilder.setPrice(0.00);
        gameBuilder.setMaxPlayers(10);
        gameBuilder.setNrOfHeroes(123);
        gameBuilder.setNrOfMaps(1);
        gameList.add(gameBuilder.getMOBAGame());

    }

}
