package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import connection.DbConnection;

class GenericDao {

	private SessionFactory sessionFactory;

	GenericDao() {
		sessionFactory = DbConnection.getSessionFactory();
	}
	
	Session openSession() {
		return sessionFactory.openSession();
	}
	
	Session getCurrentSession() {
		return sessionFactory.openSession();
	}
	
}
