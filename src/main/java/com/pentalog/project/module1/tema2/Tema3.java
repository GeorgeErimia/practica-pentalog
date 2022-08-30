package com.pentalog.project.module1.tema2;

import java.util.Scanner;

public class Tema3 {
    public static void main(String[] args) {
        GameDB database = GameDB.getInstance();
        database.addGames();

        String choice = "";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("1 - shooters | 2 - MOBA | 3 - RPG");

        choice = keyboard.nextLine();

        switch (choice) {
            case "1":
                for (ShooterGame game : database.getShooterGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            case "2":
                for (MOBAGame game : database.getMOBAGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            case "3":
                for (RPGGame game : database.getRPGGames()) {
                    System.out.println(game.iGetInfo());
                }
                break;
            default:
                System.out.println("NU AI INTRODUS NICIO OPTIUNE");
        }

    }
}
