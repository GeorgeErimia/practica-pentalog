package com.pentalog.project.module2.repository.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface StoreRepository extends PagingAndSortingRepository<Store, Integer> {

    Optional<Store> findByName (String name);
}

