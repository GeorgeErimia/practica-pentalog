package com.pentalog.project.module1.tema2;

import java.util.ArrayList;
import java.util.List;

public class GameDB {
    List<Game> gameList;

    public GameDB(List<Game> gameList) { this.gameList = gameList; }

    public List<ShooterGame> getAllShooterGames(){
        List<ShooterGame> shooterGames = new ArrayList<>();
        for(Game game : gameList){
            if(game instanceof ShooterGame){
                shooterGames.add((ShooterGame) game);
            }
        }
        return shooterGames;
    }

    public List<RPGGame> getAllRPGGames(){
        List<RPGGame> rpgGames = new ArrayList<>();
        for(Game game : gameList){
            if(game instanceof RPGGame){
                rpgGames.add((RPGGame) game);
            }
        }
        return rpgGames;
    }

    public List<MOBAGame> getAllMOBAGames(){
        List<MOBAGame> mobaGames = new ArrayList<>();
        for(Game game : gameList){
            if(game instanceof MOBAGame){
                mobaGames.add((MOBAGame) game);
            }
        }
        return mobaGames;
    }

    public GameDB(){
        gameList = new ArrayList<>();
    }

    public void addGames(){

        gameList.add(new ShooterGame(
                        "Call of Duty",
                        "29/10/2003",
                        5.99,
                        50,
                        1
                )
        );

        gameList.add(new ShooterGame(
                        "Battlefield 1942",
                        "28/06/2004",
                        9.98,
                        50,
                        1
                )
        );

        gameList.add(new ShooterGame(
                        "Call of Duty",
                        "29/10/2003",
                        15.99,
                        50,
                        1
                )
        );

        gameList.add(new RPGGame(
                "Diablo II",
                "29/06/2000",
                25.00,
                1
        ));

        gameList.add(new RPGGame(
                "Fallout 4",
                "10/11/2015",
                21.48,
                1
        ));

        gameList.add(new RPGGame(
                "Path of Exile",
                "23/10/2013",
                0.00,
                1
        ));

        gameList.add(new MOBAGame(
                "League of Legends",
                "27/10/2009",
                0.00,
                10,
                159,
                2
        ));

        gameList.add(new MOBAGame(
                "DOTA 2",
                "9/07/2013",
                0.00,
                10,
                123,
                1
        ));

    }

}
