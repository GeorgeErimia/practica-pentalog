package com.pentalog.project.module2.web.controllers.thymeleaf;


import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.store.Store;
import com.pentalog.project.module2.service.games.GameService;
import com.pentalog.project.module2.service.games.GameStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// STORE CONTROLLER FOR HANDLING THYMELEAF REQUESTS

@Controller
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final GameStoreService storeService;
    private final GameService gameService;

    // get all stores
    @GetMapping("/all")
    public String getAllStores(Model model){
        model.addAttribute("stores", storeService.getAllStores());
        return "stores-list";
    }

    // get store by id
    @GetMapping(value = "/{id}")
    public String getStoreById(@PathVariable final Integer id, Model model){
        model.addAttribute("store", storeService.getStoreById(id));
        model.addAttribute("games", storeService.getStoreById(id).getGames());
        return "store-front";
    }

    // get games from store
    @GetMapping(value = "/{id}/games")
    public String getGamesFromStore(@PathVariable final Integer id, Model model){
        model.addAttribute("games", storeService.getGamesFromStore(id));
        return "games-list";
    }

    // get stores by name
    @GetMapping(value ="/name/{name}")
    public String getStoresByName(@PathVariable final String name, Model model){
        model.addAttribute("stores", storeService.getStoresByNameJPQL(name));
        return "stores-list";
    }

    // get stores by location
    @GetMapping(value ="/location/{location}")
    public String getStoresByLocation(@PathVariable final String location, Model model){
        model.addAttribute("stores", storeService.getStoresByLocationJPQL(location));
        return "stores-list";
    }

    // add a store
    @GetMapping("/add")
    public String addStoreForm(Model model){
        model.addAttribute("store", new Store());
        return "form_store-add";
    }

    @PostMapping("/add")
    public String addStore(@ModelAttribute Store store){
        storeService.addStore(store);
        return "redirect:/stores/all";
    }

    // delete a store
    @GetMapping("/{id}/delete")
    public String deleteStore(@PathVariable final Integer id){
        storeService.deleteAllGamesFromStore(id);
        storeService.deleteStoreById(id);
        return "redirect:/stores/all";
    }

    // patch a store
    @GetMapping("/{id}/update")
    public String updateStoreForm(@PathVariable final Integer id, Model model){
        model.addAttribute("store", storeService.getStoreById(id));
        return "form_store-update";
    }

    @PostMapping("/{id}/update")
    public String updateStore(@PathVariable final Integer id, @ModelAttribute Store store, Model model){
        try{
            Store storeToUpdate = storeService.getStoreById(id);
            if(store.getName()!= null && !store.getName().isEmpty()){
                storeToUpdate.setName(store.getName());
            }
            if(store.getLocation()!= null && !store.getLocation().isEmpty()){
                storeToUpdate.setLocation(store.getLocation());
            }
            if(store.getWebsite()!= null && !store.getWebsite().isEmpty()){
                storeToUpdate.setWebsite(store.getWebsite());
            }
            storeService.patchStoreById(id, storeToUpdate);
            return "redirect:/stores/" + id;
        }catch (RuntimeException e){
            model.addAttribute("error", "Numele magazinului trebuie sa fie unic!");
            model.addAttribute("redirectPath", "/stores/" + id + "/update");
            return "error-handling-template";
        }
    }

    // assign agame to store
    @GetMapping("/{id}/assignGame")
    public String assignGameToStoreForm(@PathVariable final Integer id, Model model){
        model.addAttribute("store_id", id);
        model.addAttribute("games", gameService.getGames());
        return "form_game-assign";
    }

    @PostMapping("/{id}/assignGame")
    public String assignGameToStore(@PathVariable final Integer id, @ModelAttribute("game") final String game_id, Model model){
        try{
            final Game gameToAdd = gameService.getGameById(Integer.parseInt(game_id));
            storeService.addGameToStore(id, gameToAdd);
            return "redirect:/stores/{id}";
        }catch(RuntimeException e){
            model.addAttribute("error", e.getMessage());
            return "error-handling-template";
        }
    }

    // unassign a game from store
    @GetMapping("/{id}/unassign")
    public String unAssignGameFromStoreForm(@PathVariable final Integer id, Model model){
        model.addAttribute("store_id", id);
        model.addAttribute("games", storeService.getGamesFromStore(id));
        return "form_game-unassign";
    }

    @PostMapping("/{id}/unassign")
    public String unAssignGameFromStore(@PathVariable final Integer id, @ModelAttribute("game") final String game_id, Model model){
        try{
            System.out.println("game_id = " + game_id);
            storeService.deleteGameFromStore(id, Integer.parseInt(game_id));
            return "redirect:/stores/{id}";
        }catch(RuntimeException e){
            model.addAttribute("error", e.getMessage());
            return "error-handling-template";
        }
    }

}
