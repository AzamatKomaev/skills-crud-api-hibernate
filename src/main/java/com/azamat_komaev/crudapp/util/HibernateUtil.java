package com.azamat_komaev.crudapp.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration();
            sessionFactory = cfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            ex.printStackTrace(System.out);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}