package com.pentalog.project.module2.web.rest;

import com.pentalog.project.module2.model.dtos.StoreDto;
import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.store.Store;
import com.pentalog.project.module2.service.converters.StoreConverter;
import com.pentalog.project.module2.service.games.GameStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
public class GameStoreRestController {

    private final GameStoreService gameStoreService;

    // get store by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable final Integer id){

        return ResponseEntity.ok(gameStoreService.getStoreById(id));
    }

    // get store by name
    @GetMapping(value = "/name/{name}")
    public StoreDto getStoreByName(@PathVariable final String name){
        return StoreConverter.toDto(gameStoreService.getStoreByName(name));
    }

    // get all stores by name
    @GetMapping(value = "/nameJPQL/{name}")
    public List<StoreDto> getStoreByNameJPQL(@PathVariable final String name){
        return StoreConverter.toDto(gameStoreService.getStoresByNameJPQL(name));
    }

    // create a store
    @PostMapping()
    public ResponseEntity<Store> createStore(@RequestBody final StoreDto store){
        final Store createdStore = gameStoreService.addStore(StoreConverter.toEntity(store));
        return ResponseEntity.created(URI.create("/api/v1/stores/" + createdStore.getId())).build();
    }

    // add a game to store
    @PostMapping(value = "/{id}/games")
    public ResponseEntity<Game> createGame(@PathVariable final Integer id, @RequestBody Game game){
        final Game gameToAdd = gameStoreService.addGameToStore(id, game);
        return ResponseEntity.created(URI.create("/api/v1/games/" + gameToAdd.getId())).build();
    }

    // update a store
    @PutMapping(value = "/{id}")
    public StoreDto updateStore(@PathVariable final Integer id, @RequestBody final StoreDto store){
        return StoreConverter.toDto(gameStoreService.patchStoreById(id, StoreConverter.toEntity(store)));
    }

    // patch a store
    @PatchMapping(value = "/{id}")
    public StoreDto patchStore(@PathVariable final Integer id, @RequestBody final StoreDto store){
        return StoreConverter.toDto(gameStoreService.patchStoreById(id, StoreConverter.toEntity(store)));
    }

    // delete a store
    @DeleteMapping(value = "/{id}")
    public void deleteStore(@PathVariable final Integer id){
        gameStoreService.deleteStoreById(id);
    }

}
