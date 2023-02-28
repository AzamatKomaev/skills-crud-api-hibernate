package com.azamat_komaev.crudapp.config;

import com.azamat_komaev.crudapp.model.Specialty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class Database implements AutoCloseable {
    private static Database instance;
    private SessionFactory sessions;
    private Session session;

    private Database() {
    }

    public Session getSession() {
        Configuration cfg = new Configuration().addClass(Specialty.class);
        sessions = cfg.buildSessionFactory();
        session = sessions.openSession();
        return session;
    }

    public Connection getConnection() {
        return null;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    @Override
    public void close() {
        sessions.close();
        session.close();
    }
}
