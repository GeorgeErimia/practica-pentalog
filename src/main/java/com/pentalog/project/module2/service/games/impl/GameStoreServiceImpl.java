package com.pentalog.project.module2.service.games.impl;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.game.GameRepository;
import com.pentalog.project.module2.repository.store.Store;
import com.pentalog.project.module2.repository.store.StoreRepository;
import com.pentalog.project.module2.repository.store.StoreQuery;
import com.pentalog.project.module2.service.games.GameStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class GameStoreServiceImpl implements GameStoreService {

    private final StoreRepository storeRepository;
    private final StoreQuery storeJPQLRepo;

    // Add a store
    @Override
    public Store addStore(@Valid Store store) {

        return storeRepository.save(store);
    }

    // Get store by id
    @Override
    public Store getStoreById(@NotNull Integer id) {

        return storeRepository.findById(id).orElse(null);
    }

    // Get store by name
    @Override
    public Store getStoreByName(@NotNull String name) {

        return storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Store not found"));
    }

    // Get all stores
    @Override
    public List<Store> getAllStores() {

        List<Store> stores = new ArrayList<>();
        storeRepository.findAll().forEach(stores::add);

        return stores;
    }

    // Get stores by name using JPQL
    @Override
    public List<Store> getStoresByNameJPQL(@NotNull String name) {
            List<Store> storesByNameJPQL = storeJPQLRepo.findByNameJPQL(name);
            return storesByNameJPQL;
    }

    // Get stores by location using JPQL
    @Override
    public List<Store> getStoresByLocationJPQL(@NotNull String location) {
            List<Store> storesByLocationJPQL = storeJPQLRepo.findByLocationJPQL(location);
            return storesByLocationJPQL;
    }

    // Update store by id
    @Override
    public Store updateStoreById(@NotNull Integer id, @Valid Store store) {

        Store storeToUpdate = storeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        if(store.getName() != null){
            storeToUpdate.setName(store.getName());
        } else throw new RuntimeException("Store name cannot be null");


        storeToUpdate.setWebsite(store.getWebsite());

        if(store.getLocation() != null){
            storeToUpdate.setLocation(store.getLocation());
        } else throw new RuntimeException("Store location cannot be null");

        if(store.getGames() != null){
            storeToUpdate.setGames(store.getGames());
        } else throw new RuntimeException("Store games cannot be null");

        return storeRepository.save(storeToUpdate);
    }

    // Patch a store by id
    @Override
    @Transactional
    public Store patchStoreById(@NotNull Integer id, Store store) {
        Store storeToUpdate = storeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        if(store.getName() != null){
            storeToUpdate.setName(store.getName());
        } else throw new RuntimeException("Store name cannot be null");

        storeToUpdate.setWebsite(store.getWebsite());

        if(store.getLocation() != null){
            storeToUpdate.setLocation(store.getLocation());
        } else throw new RuntimeException("Store location cannot be null");

        if(store.getGames() != null){
            storeToUpdate.setGames(store.getGames());
        } else throw new RuntimeException("Store games cannot be null");

        return storeRepository.save(storeToUpdate);
    }

    // Delete store by id
    @Override
    public Boolean deleteStoreById(@NotNull Integer id) {
        if(storeRepository.existsById(id)){
            storeRepository.deleteById(id);
            return true;
        } else return false;
    }

    @Override
    public List<Game> getGamesFromStore(Integer id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
        return store.getGames();
    }

    @Override
    public Game addGameToStore(Integer id, Game game) {

        final Store store = storeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        if(store.getGames().contains(game)){
            throw new RuntimeException("Game already exists in store");
        } else {
            store.getGames().add(game);
            storeRepository.save(store);
        }

        return game;
    }

    @Override
    public void deleteGameFromStore(Integer id, Integer gameId) {

            final Store store = storeRepository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Store not found"));

            store.getGames().removeIf(game -> game.getId().equals(gameId));

            storeRepository.save(store);
    }

    @Override
    public void deleteAllGamesFromStore(Integer id) {

            final Store store = storeRepository
                    .findById(id)
                    .orElseThrow(() -> new RuntimeException("Store not found"));

            store.getGames().clear();

            storeRepository.save(store);
    }
}
