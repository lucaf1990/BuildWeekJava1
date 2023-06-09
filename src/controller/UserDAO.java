package controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import model.User;

public class UserDAO {
	public static void saveUser(User u) throws PersistenceException {
		MainProject.em.getTransaction().begin();
		MainProject.em.persist(u);
		MainProject.em.getTransaction().commit();
		System.out.println("User was correctly saved in your User's list");
	}
	
	public static void updateUser(User u) throws PersistenceException {
		MainProject.em.getTransaction().begin();
		MainProject.em.merge(u);
		MainProject.em.getTransaction().commit();
		System.out.println("User was correctly updated");
	}
	
	public static User getByID(Long id) throws PersistenceException {
		MainProject.em.getTransaction().begin();
		User u = MainProject.em.find(User.class, id);
		MainProject.em.getTransaction().commit();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public static List<User> findAll() {
		Query q = MainProject.em.createNamedQuery("User.findAll");
		return q.getResultList();
	}
	
}
