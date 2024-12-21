package br.com.sistemajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUltil {
	
	public static EntityManagerFactory factory = null;
	
	 static {
		 init();
	 }
	 
	 private static void init() {
		 
		 try {
			 
			 if(factory == null) {
				 factory = Persistence.createEntityManagerFactory("sistema-jpa");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	 public static EntityManager getEntityManager() {
		 return factory.createEntityManager();
	 }
	 
	 //metodo de retorna chave primaria 
	 public static Object getprimarykey(Object entity) {
		 return factory.getPersistenceUnitUtil().getIdentifier(entity);
	 }

}
