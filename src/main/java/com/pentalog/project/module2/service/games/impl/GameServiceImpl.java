package com.pentalog.project.module2.service.games.impl;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.game.GameRepository;
import com.pentalog.project.module2.service.games.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;


    // Adds a new game to the database
    @Override
    public Game addGame(@Valid Game game) {
        return gameRepository.save(game);
    }


    // Get game from database by id
    @Override
    public Game getGameById(@NotNull Integer id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }


    // Get game from database by name
    @Override
    public Game getGameByName(@NotNull String name) {
        return gameRepository.findByName(name).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public Game updateGameById(@NotNull Integer id, Game game) {
        Game gameToUpdate = gameRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        gameToUpdate.setName(game.getName());
        gameToUpdate.setReleaseDate(game.getReleaseDate());
        gameToUpdate.setDescription(game.getDescription());
        gameToUpdate.setImageUrl(game.getImageUrl());
        gameToUpdate.setTrailerUrl(game.getTrailerUrl());
        gameToUpdate.setGenre(game.getGenre());
        gameToUpdate.setPlatform(game.getPlatform());
        gameToUpdate.setPublisher(game.getPublisher());
        gameToUpdate.setDeveloper(game.getDeveloper());
        gameToUpdate.setRating(game.getRating());
        gameToUpdate.setPrice(game.getPrice());

        return gameRepository.save(gameToUpdate);
    }

    @Override
    public Game patchGameById(@NotNull Integer id, Game game) {
        Game gameToUpdate = gameRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));

        if (game.getName() != null) {
            gameToUpdate.setName(game.getName());
        }

        if (game.getReleaseDate() != null) {
            gameToUpdate.setReleaseDate(game.getReleaseDate());
        }

        if (game.getDescription() != null) {
            gameToUpdate.setDescription(game.getDescription());
        }

        if (game.getImageUrl() != null) {
            gameToUpdate.setImageUrl(game.getImageUrl());
        }

        if (game.getTrailerUrl() != null) {
            gameToUpdate.setTrailerUrl(game.getTrailerUrl());
        }

        if (game.getGenre() != null) {
            gameToUpdate.setGenre(game.getGenre());
        }

        if (game.getPlatform() != null) {
            gameToUpdate.setPlatform(game.getPlatform());
        }

        if (game.getPublisher() != null) {
            gameToUpdate.setPublisher(game.getPublisher());
        }

        if (game.getDeveloper() != null) {
            gameToUpdate.setDeveloper(game.getDeveloper());
        }

        if (game.getRating() != null) {
            gameToUpdate.setRating(game.getRating());
        }

        return gameRepository.save(gameToUpdate);
    }

    @Override
    public void deleteGameById(@NotNull Integer id) {
        gameRepository.deleteById(id);
    }
}
