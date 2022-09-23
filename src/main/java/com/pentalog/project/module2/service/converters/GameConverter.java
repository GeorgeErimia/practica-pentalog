package com.pentalog.project.module2.service.converters;

import com.pentalog.project.module2.model.dtos.GameDto;
import com.pentalog.project.module2.repository.game.Game;

import java.util.List;
import java.util.stream.Collectors;

public class GameConverter {

    public static GameDto toDto (Game game){

        return new GameDto()
                .setName(game.getName())
                .setReleaseDate(game.getReleaseDate())
                .setDescription(game.getDescription())
                .setImageUrl(game.getImageUrl())
                .setTrailerUrl(game.getTrailerUrl())
                .setGenre(game.getGenre())
                .setPlatform(game.getPlatform())
                .setPublisher(game.getPublisher())
                .setDeveloper(game.getDeveloper())
                .setRating(game.getRating())
                .setPrice(game.getPrice());
    }

    public static Game toEntity (GameDto gameDto){

        return new Game()
                .setName(gameDto.getName())
                .setReleaseDate(gameDto.getReleaseDate())
                .setDescription(gameDto.getDescription())
                .setImageUrl(gameDto.getImageUrl())
                .setTrailerUrl(gameDto.getTrailerUrl())
                .setGenre(gameDto.getGenre())
                .setPlatform(gameDto.getPlatform())
                .setPublisher(gameDto.getPublisher())
                .setDeveloper(gameDto.getDeveloper())
                .setRating(gameDto.getRating())
                .setPrice(gameDto.getPrice());
    }

    public static List<GameDto> toDto (List<Game> games){

        return games.stream()
                .map(GameConverter::toDto)
                .collect(Collectors.toList());
    }

    public static List<Game> toEntity (List<GameDto> gameDtos){

        return gameDtos.stream()
                .map(GameConverter::toEntity)
                .collect(Collectors.toList());
    }
}
