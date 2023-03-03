package com.azamat_komaev.crudapp.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateService {
    private static HibernateService instance;
    private final Session session;

    private HibernateService() {
        session = buildSessionFactory().openSession();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static HibernateService getInstance() {
        if (instance == null) {
            instance = new HibernateService();
        }

        return instance;
    }

    public Session getSession() {
        return session;
    }
}
