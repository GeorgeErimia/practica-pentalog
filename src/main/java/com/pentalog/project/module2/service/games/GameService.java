package com.pentalog.project.module2.service.games;

import com.pentalog.project.module2.repository.game.Game;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface GameService {

    // Add a game
    Game addGame(@Valid Game game);

    // Get game by id
    Game getGameById(@NotNull Integer id);

    // Get all games
    List<Game> getGames();

    // Get game by name
    Game getGameByName(@NotNull String name);

    // Update game by id
    Game updateGameById(@NotNull Integer id, @Valid Game game);

    // Patch a game by id
    Game patchGameById(@NotNull Integer id, Game game);

    // Delete game by id
    void deleteGameById(@NotNull Integer id);
}
