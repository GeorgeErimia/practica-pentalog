package com.pentalog.project.module2.service.games.impl;

import com.pentalog.project.module2.repository.game.Game;
import com.pentalog.project.module2.repository.store.Store;
import com.pentalog.project.module2.service.games.GameStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class GameStoreServiceImpl implements GameStoreService {
    @Override
    public Store addStore(Store store) {
        return null;
    }

    @Override
    public Store getStoreById(Integer id) {
        return null;
    }

    @Override
    public Store getStoreByName(String name) {
        return null;
    }

    @Override
    public Page<Store> getAllStores(PageRequest request) {
        return null;
    }

    @Override
    public Store updateStoreById(Integer id, Store store) {
        return null;
    }

    @Override
    public Store patchStoreById(Integer id, Store store) {
        return null;
    }

    @Override
    public void deleteStoreById(Integer id) {

    }

    @Override
    public Game addGameToStore(Integer id, Game game) {
        return null;
    }
}
