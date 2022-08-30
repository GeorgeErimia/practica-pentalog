package com.pentalog.project.module1.tema2;

import com.pentalog.project.module1.tema2.Game;
import com.pentalog.project.module1.tema2.GameInterface;

public class MOBAGame extends Game implements GameInterface {
    private int maxPlayers; // Represents the maximum number of players in a single session
    private int nrOfHeroes; // number of playable characters in the game
    private int nrOfMaps; // number of maps that players could enjoy

    public MOBAGame(String name,
                    String releaseDate,
                    double price,
                    int maxPlayers,
                    int nrOfHeroes,
                    int nrOfMaps) {
        super(name, releaseDate, price);
        this.maxPlayers = maxPlayers;
        this.nrOfHeroes = nrOfHeroes;
        this.nrOfMaps = nrOfMaps;
    }

    // GETTERS
    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getNrOfHeroes() {
        return nrOfHeroes;
    }

    public int getNrOfMaps() {
        return nrOfMaps;
    }

    @Override
    public String iGetInfo() {
        // Build basic info
        StringBuilder str = new StringBuilder();
        str.append(getBasicInfo());

        // Build more complex info
        str.append("Release Date : " + this.releaseDate + "\r\n");

        str.append("Max Players in a match: ");
        if (maxPlayers == 1)
            str.append("Singleplayer\r\n");
        else str.append(maxPlayers + "\r\n");

        str.append("Number of Heroes : " + nrOfHeroes + "\r\n");
        str.append("Number of Maps : " + nrOfMaps + "\r\n");

        return str.toString();
    }
}
