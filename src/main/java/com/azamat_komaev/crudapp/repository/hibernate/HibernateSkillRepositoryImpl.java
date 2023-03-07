package com.azamat_komaev.crudapp.repository.hibernate;

import com.azamat_komaev.crudapp.model.Skill;
import com.azamat_komaev.crudapp.repository.SkillRepository;
import com.azamat_komaev.crudapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.*;

public class HibernateSkillRepositoryImpl implements SkillRepository {
    public HibernateSkillRepositoryImpl() {
    }

    @Override
    public Skill getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Skill.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Skill> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Skill", Skill.class).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Skill save(Skill skill) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.save(skill);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.refresh(skill);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return skill;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.remove(session.get(Skill.class, id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}

