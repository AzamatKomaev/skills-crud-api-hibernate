package com.azamat_komaev.crudapp.repository.hibernate;

import com.azamat_komaev.crudapp.model.Developer;
import com.azamat_komaev.crudapp.repository.DeveloperRepository;
import com.azamat_komaev.crudapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.*;

public class HibernateDeveloperRepositoryImpl implements DeveloperRepository {

    public HibernateDeveloperRepositoryImpl() {
    }

    @Override
    public Developer getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery(
             "from Developer d " +
                "left join fetch d.skills " +
                "left join fetch d.specialty " +
                "where d.id = :id",
                Developer.class
            ).setParameter("id", id).getSingleResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery(
             "from Developer d " +
                "left join fetch d.skills " +
                "left join fetch d.specialty",
                 Developer.class
            ).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Developer save(Developer developer) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.save(developer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.refresh(developer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return developer;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.remove(session.get(Developer.class, id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
