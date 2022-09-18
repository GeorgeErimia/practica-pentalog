package com.pentalog.project.module2.repository.game;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Integer> {

  Optional<Game> findByName (String name);

}

