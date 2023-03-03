package com.azamat_komaev.crudapp.repository.jdbc;

import com.azamat_komaev.crudapp.model.Skill;
import com.azamat_komaev.crudapp.repository.SkillRepository;
import com.azamat_komaev.crudapp.service.HibernateService;
import jakarta.persistence.EntityManager;

import java.util.*;

public class JdbcSkillRepositoryImpl implements SkillRepository {

    public JdbcSkillRepositoryImpl() {
    }

    @Override
    public Skill getById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.find(Skill.class, id);
    }

    @Override
    public List<Skill> getAll() {
        EntityManager entityManager = HibernateService.getInstance().getSession();
        return entityManager.createQuery("from Skill", Skill.class).getResultList();
    }

    @Override
    public Skill save(Skill skill) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();

        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();

        return skill;
    }

    @Override
    public void deleteById(Integer id) {
        EntityManager entityManager = HibernateService.getInstance().getSession();

        entityManager.getTransaction().begin();
        entityManager.
            createQuery("delete Skill where id=:id")
            .setParameter("id", id)
            .executeUpdate();
        entityManager.getTransaction().commit();
    }
}

