package com.azamat_komaev.crudapp.repository.jdbc;

import com.azamat_komaev.crudapp.model.Specialty;
import com.azamat_komaev.crudapp.repository.SpecialtyRepository;
import com.azamat_komaev.crudapp.service.HibernateService;
import jakarta.persistence.EntityManager;

import java.util.*;

public class JdbcSpecialtyRepositoryImpl implements SpecialtyRepository {
    public JdbcSpecialtyRepositoryImpl() {
    }

    @Override
    public Specialty getById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.find(Specialty.class, id);
    }

    @Override
    public List<Specialty> getAll() {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.createQuery("from Specialty", Specialty.class).getResultList();
    }

    @Override
    public Specialty save(Specialty specialty) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(specialty);
        entityManager.getTransaction().commit();

        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(specialty);
        entityManager.getTransaction().commit();

        return specialty;
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.
            createQuery("delete Specialty where id=:id")
            .setParameter("id", id)
            .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
