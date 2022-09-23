package com.pentalog.project.module2.web.controllers.thymeleaf;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.service.games.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// GAME CONTROLLER FOR HANDLING THYMELEAF REQUESTS

@Controller
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    // get all games
    @GetMapping("/all")
    public String getAllGames(Model model){
        model.addAttribute("games", gameService.getGames());
        return "games-list";
    }

    // get game by id
    @GetMapping(value = "/{id}")
    public String getGameById(@PathVariable final Integer id, Model model){
        model.addAttribute("game", gameService.getGameById(id));
        return "view-game";
    }

    // get games by name
    @GetMapping(value = "/name/{name}")
    public String getGameByName(@PathVariable final String name, Model model){
        model.addAttribute("games", gameService.getGameByName(name));
        return "games-list";
    }

    // add a game
    @GetMapping("/add")
    public String addGameForm(Model model){
        model.addAttribute("game", new Game());
        return "form_game-add";
    }

    @PostMapping("/add")
    public String addGame(@ModelAttribute Game game, Model model){
        try{
            gameService.addGame(game);
            return "redirect:/games/all";
        }catch (Exception e){
            model.addAttribute("error", "Game already exists. Try another name.");
            model.addAttribute("redirectPath", "/games/add");
            return "error-handling-template";
        }
    }

    // update a game
    @GetMapping("/{id}/update")
    public String updateGameForm(@PathVariable final Integer id, Model model){
        model.addAttribute("game", gameService.getGameById(id));
        return "form_game-update";
    }

    @PostMapping("/{id}/update")
    public String updateGame(@PathVariable final Integer id, @ModelAttribute Game game, Model model){
        try{
            gameService.updateGameById(id, game);
            return "redirect:/games/all";
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
            model.addAttribute("redirectPath", "/games/" + id + "/update");
            return "error-handling-template";
        }
    }

    // delete a game
    @GetMapping("/{id}/delete")
    public String deleteGame(@PathVariable final Integer id, Model model){
        try{
            gameService.deleteGameById(id);
            return "redirect:/games/all";
        }catch (Exception e){
            model.addAttribute("error", "Game exists in a store. Please delete it from the store first.");
            model.addAttribute("redirectPath", "/games/all");
            return "error-handling-template";
        }
    }

}
