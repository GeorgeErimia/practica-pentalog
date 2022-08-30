package com.pentalog.project.module1.tema2;

import com.pentalog.project.module1.tema2.Game;
import com.pentalog.project.module1.tema2.GameInterface;

public class RPGGame extends Game implements GameInterface {

    private int maxPlayers; // Represents the maximum number of players in a single session

    public RPGGame(String name, String releaseDate, double price, int maxPlayers) {
        super(name, releaseDate, price);
        this.maxPlayers = maxPlayers;
    }

    @Override
    public String iGetInfo() {
        StringBuilder str = new StringBuilder("");
        str.append(this.getBasicInfo());

        str.append("Release date : " + releaseDate + "\r\n");

        str.append("Max Players in a match: ");
        if (maxPlayers == 1)
            str.append("Singleplayer\r\n");
        else str.append(maxPlayers + "\r\n");

        return str.toString();
    }
}
