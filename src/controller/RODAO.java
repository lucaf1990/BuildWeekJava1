package controller;

import model.Route;
import model.TravelPasses;

public class RODAO {
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
