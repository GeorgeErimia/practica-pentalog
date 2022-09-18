package com.pentalog.project.module2.service.games;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface GameStoreService {

    Store addStore(@Valid Store store);

    Store getStoreById(@NotNull Integer id);

    Store getStoreByName(@NotNull String name);

    Page<Store> getAllStores(PageRequest request);

    //  update store by id
    Store updateStoreById(@NotNull Integer id, @Valid Store store);

    //  patch a store
    Store patchStoreById(@NotNull Integer id, Store store);

    //  delete store by id
    void deleteStoreById(@NotNull Integer id);

    Game addGameToStore(Integer id, @Valid Game game);
}
