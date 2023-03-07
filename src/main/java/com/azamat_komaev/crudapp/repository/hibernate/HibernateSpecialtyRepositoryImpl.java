package com.azamat_komaev.crudapp.repository.hibernate;

import com.azamat_komaev.crudapp.model.Specialty;
import com.azamat_komaev.crudapp.repository.SpecialtyRepository;
import com.azamat_komaev.crudapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.*;

public class HibernateSpecialtyRepositoryImpl implements SpecialtyRepository {
    public HibernateSpecialtyRepositoryImpl() {
    }

    @Override
    public Specialty getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Specialty.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Specialty> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Specialty", Specialty.class).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.save(specialty);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.refresh(specialty);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        return specialty;
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.getTransaction().begin();
            session.remove(session.get(Specialty.class, id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
