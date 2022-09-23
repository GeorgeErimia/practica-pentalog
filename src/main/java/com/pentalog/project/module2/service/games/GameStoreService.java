package com.pentalog.project.module2.service.games;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.store.Store;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface GameStoreService {

    // add a store
    Store addStore(@Valid Store store);

    // get store by id
    Store getStoreById(@NotNull Integer id);

    // get store by name
    Store getStoreByName(@NotNull String name);

    // get all stores
    List<Store> getAllStores();

    //  update store by id
    Store updateStoreById(@NotNull Integer id, @Valid Store store);

    //  patch a store by id
    @Transactional
    Store patchStoreById(@NotNull Integer id, Store store);

    //  delete store by id
    Boolean deleteStoreById(@NotNull Integer id);

    // get games from a store
    List<Game> getGamesFromStore(@NotNull Integer id);

    // add a game to a store
    Game addGameToStore(Integer id, @Valid Game game);

    // delete game from a store
    void deleteGameFromStore(Integer id, Integer gameId);

    // delete all games from a store
    void deleteAllGamesFromStore(Integer id);

    // get stores by name using JPQL
    List<Store> getStoresByNameJPQL(@NotNull String name);

    // get stores by location using JPQL
    List<Store> getStoresByLocationJPQL(@NotNull String location);
}
