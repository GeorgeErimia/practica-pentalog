package com.pentalog.project.module1.streams;

import com.pentalog.project.module1.tema2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //      STREAMS

        // Initialize games list (From GameDB instance)
        List<Game> games = GameDB.getInstance().getGames();

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
