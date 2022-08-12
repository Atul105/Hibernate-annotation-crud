package magar.atul.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import magar.atul.model.Product;

public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		
		//load configuration
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class).buildSessionFactory();
		
		return factory;
	}
	

}
