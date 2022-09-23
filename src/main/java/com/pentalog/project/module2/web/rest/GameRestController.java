package com.pentalog.project.module2.web.rest;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.service.games.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameRestController {

    private final GameService gameService;

    // get game by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable final Integer id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    // get game by name
    @GetMapping(value = "/name/{name}")
    public Game getGameByName(@PathVariable final String name) {
        return gameService.getGameByName(name);
    }

    // create a game
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game){

        final Game addedGame = gameService.addGame(game);
        return ResponseEntity.created(URI.create("/api/v1/games/" + addedGame.getId())).build();
    }

    // update a game
    @PutMapping(value = "/{id}")
    public Game updateGame(@PathVariable final Integer id, @RequestBody Game game){

        return gameService.updateGameById(id, game);
    }

    // patch a game
    @PatchMapping(value = "/{id}")
    public Game patchGame(@PathVariable final Integer id, @RequestBody Game game){

        return gameService.patchGameById(id, game);
    }

    // delete a game
    @DeleteMapping(value = "/{id}")
    public void deleteGame(@PathVariable final Integer id){

        gameService.deleteGameById(id);
    }

}
