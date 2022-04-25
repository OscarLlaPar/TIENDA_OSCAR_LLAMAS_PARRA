package curso.java.modelo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
private static SessionFactory sessionFactory;
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
//		Configuration configuration = new Configuration();
//		configuration.configure();
//		sessionFactory = configuration.buildSessionFactory();
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null)
			sessionFactory = configureSessionFactory();
		return sessionFactory;
	}
}
