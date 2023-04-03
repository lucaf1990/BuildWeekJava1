package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import connector.JpaUtil;
import model.User;

public class MainProject {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
	System.out.println("connected");
	
	
	User user_0= new User("Luca","Forma",LocalDate.of(2023, 02, 20));


	saveUser(user_0);
	
	
	}

	public static void saveUser(User u) throws PersistenceException {
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("User was correctly saved in your User's list");
		
	}
	
	
}
