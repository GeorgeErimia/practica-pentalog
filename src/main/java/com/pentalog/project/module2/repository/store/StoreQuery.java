package com.pentalog.project.module2.repository.store;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class StoreQuery {

    @PersistenceContext
    EntityManager entityManager;

    public List<Store> findByNameJPQL(String name){
        return entityManager.createQuery("select s from Store s where s.name = :name", Store.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Store> findByLocationJPQL(String location){
        return entityManager.createQuery("select s from Store s where s.location = :location", Store.class)
                .setParameter("location", location)
                .getResultList();
    }
}
