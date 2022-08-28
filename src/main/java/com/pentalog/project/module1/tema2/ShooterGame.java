package com.pentalog.project.module1.tema2;

import com.pentalog.project.module1.tema2.Game;
import com.pentalog.project.module1.tema2.GameInterface;

public class ShooterGame extends Game implements GameInterface {

    private int maxPlayers; // Represents the maximum number of players in a single match
    private int nrOfClasses; // Represents the classes of players that game has

    // CONSTRUCTOR - inherited from Game class
    public ShooterGame(String name,
                       String releaseDate,
                       double price,
                       int maxPlayers,
                       int nrOfClasses) {
        super(name, releaseDate, price);
        this.maxPlayers = maxPlayers;
        this.nrOfClasses = nrOfClasses;
    }

    @Override
    public String iGetInfo() {
        // Build basic Info
        StringBuilder str = new StringBuilder("");
        str.append(this.getBasicInfo());

        // Build more complex info
        str.append("Release Date: " + this.releaseDate + "\r\n");

        str.append("Max Players in a match: ");
        if (maxPlayers == 1)
            str.append("Singleplayer\r\n");
        else str.append(maxPlayers + "\r\n");

        str.append("Number of classes: " + nrOfClasses + "\r\n");

        return str.toString();
    }
}
