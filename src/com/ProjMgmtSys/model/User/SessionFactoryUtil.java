package com.ProjMgmtSys.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class SessionFactoryUtil{
	private static final SessionFactory sessionFactory;
	static {
		try {
			// Create the SessionFactory from user.cfg.xml
			sessionFactory = new Configuration().configure("/com/ProjMgmtSys/configuration/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	} 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	} 
}