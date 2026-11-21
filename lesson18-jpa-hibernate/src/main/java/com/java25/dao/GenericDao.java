package com.java25.dao;

import com.java25.connection.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDao {
    private SessionFactory sessionFactory;

    GenericDao() {
        sessionFactory = DbConnection.getSessionFactory();
    }

    Session openSession() {
        return sessionFactory.openSession();
    }

    Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}

