package com.pentalog.project.module1.tema2;

import java.util.Scanner;

public class Tema3 {
    public static void main(String[] args) {
        GameDB database = new GameDB();
        database.addGames();

        String choice = "";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("1 - shooters | 2 - MOBA | 3 - RPG");

        choice = keyboard.nextLine();

        switch (choice) {
            case "1":
                for (ShooterGame game : database.getAllShooterGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            case "2":
                for (MOBAGame game : database.getAllMOBAGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            case "3":
                for (RPGGame game : database.getAllRPGGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            default:
                System.out.println("NU AI INTRODUS NICIO OPTIUNE");
        }

    }
}
