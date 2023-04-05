package controller;

import model.Route;

public class RODAO {
	
	public static Route getByID(Long id) {
		MainProject.em.getTransaction().begin();
		Route r = MainProject.em.find(Route.class, id);
		MainProject.em.getTransaction().commit();
		return r;
	}
	
	public static void saveRoute(Route r) {
		MainProject.em.getTransaction().begin();
		MainProject.em.persist(r);
		MainProject.em.getTransaction().commit();
		System.out.println("Route was correctly created");
	}
	
	public static void updateRoute (Route r) {
		MainProject.em.getTransaction().begin();
		MainProject.em.merge(r);
		MainProject.em.getTransaction().commit();
		System.out.println("Route was correctly updated");
	}
	
}
