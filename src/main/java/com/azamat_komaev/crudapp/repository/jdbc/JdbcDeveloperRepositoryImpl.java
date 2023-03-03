package com.azamat_komaev.crudapp.repository.jdbc;

import com.azamat_komaev.crudapp.model.Developer;
import com.azamat_komaev.crudapp.repository.DeveloperRepository;
import com.azamat_komaev.crudapp.service.HibernateService;
import jakarta.persistence.EntityManager;

import java.util.*;

public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    public JdbcDeveloperRepositoryImpl() {
    }

    @Override
    public Developer getById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.find(Developer.class, id);
    }

    @Override
    public List<Developer> getAll() {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.createQuery("from Developer", Developer.class).getResultList();
    }

    @Override
    public Developer save(Developer developer) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();

        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();

        return developer;
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager
            .createQuery("delete Developer where id=:id")
            .setParameter("id", id)
            .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
