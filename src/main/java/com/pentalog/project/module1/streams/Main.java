package com.pentalog.project.module1.streams;

import com.pentalog.project.module1.tema2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void addGames(List<Game> games){
        games.add(new ShooterGame(
                        "Call of Duty",
                        "29/10/2003",
                        5.99,
                        50,
                        1
                )
        );

        games.add(new ShooterGame(
                        "Battlefield 1942",
                        "28/06/2004",
                        9.98,
                        50,
                        1
                )
        );

        games.add(new ShooterGame(
                        "Apex Legends",
                        "04/02/2019",
                        0.00,
                        100,
                        4
                )
        );

        games.add(new RPGGame(
                "Diablo II",
                "29/06/2000",
                25.00,
                1
        ));

        games.add(new RPGGame(
                "Fallout 4",
                "10/11/2015",
                21.48,
                1
        ));

        games.add(new RPGGame(
                "Path of Exile",
                "23/10/2013",
                0.00,
                1
        ));

        games.add(new MOBAGame(
                "League of Legends",
                "27/10/2009",
                0.00,
                10,
                159,
                2
        ));

        games.add(new MOBAGame(
                "DOTA 2",
                "9/07/2013",
                0.00,
                10,
                123,
                1
        ));
    }
    public static void main(String[] args) {
        //      STREAMS

        // Initialize games list
        List<Game> games = new ArrayList<>();
        addGames(games);

        // Get only ShooterGames
        System.out.println("List of only ShooterGames");
        List<ShooterGame> shooterGames = games
                .stream()
                .filter(game -> game instanceof ShooterGame)
                .map(game -> (ShooterGame) game)
                .collect(Collectors.toList());

        // Print them
        shooterGames
                .stream()
                .forEach(game -> System.out.println(game.iGetInfo()));

        // Get only RPG Games that start with "D"
        System.out.println("RPGs that start with 'D' ");
        List<RPGGame> rpgGamesD = games
                .stream()
                .filter(game -> game instanceof RPGGame)
                .map(game -> (RPGGame) game)
                .filter(game -> game.getName().startsWith("D"))
                .collect(Collectors.toList());

        // Print them
        rpgGamesD
                .stream()
                .forEach(game -> System.out.println(game.iGetInfo()));

        // Get only MOBAs
        // that have a price less than or equal to 15$
        // and are multiplayer
        // print only basic info
        System.out.println("MOBA games that are less than 15$ and multiplayer");

        List<MOBAGame> mobaGames = games
                .stream()
                .filter(game -> game instanceof MOBAGame)
                .map(game -> (MOBAGame) game)
                .filter(game -> game.getPrice() <= 15.00)
                .filter(game -> game.getMaxPlayers() > 1)
                .collect(Collectors.toList());

        // Print them
        mobaGames
                .stream()
                .forEach(game -> System.out.println(game.getBasicInfo()));


        // Add a 20% discount to all games over 10$
        double discount = 20;
        System.out.println("!!!!Games with 20% discount!!!!");

        // First, get all games over 10$
        List<Game> discountGames = games
                .stream()
                .filter(game -> game.getPrice() >= 10.0)
                .collect(Collectors.toList());

        // Then add the discount and print them
        discountGames
                .stream()
                .forEach(game -> {
                    game.addDiscount(discount);
                    System.out.println(game.getBasicInfo());
                });


    }
}
