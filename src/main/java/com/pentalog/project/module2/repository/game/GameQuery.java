package com.pentalog.project.module2.repository.game;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class GameQuery {

    @PersistenceContext
    EntityManager entityManager;

    // Get games if contains name JPQL
    public List<Game> findByNameJPQL(String name){
        return entityManager.createQuery("select g from Game g where g.name like :name", Game.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    // Get games by genre JPQL
    public List<Game> findByGenreJPQL(String genre){
        return entityManager.createQuery("select g from Game g where g.genre = :genre", Game.class)
                .setParameter("genre", genre)
                .getResultList();
    }

    // Get games by platform JPQL
    public List<Game> findByPlatformJPQL(String platform){
        return entityManager.createQuery("select g from Game g where g.platform = :platform", Game.class)
                .setParameter("platform", platform)
                .getResultList();
    }

}
