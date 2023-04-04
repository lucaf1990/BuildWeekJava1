package controller;

import model.TravelPasses;
import model.Vehicle;

public class VDAO {

	public static void saveVehicle(Vehicle v) {
		MainProject.em.getTransaction().begin();
		MainProject.em.persist(v);
		MainProject.em.getTransaction().commit();
		System.out.println("Vehicle was correctly saved");
	}
	
	public static void updateVeichle(Vehicle v) {
		MainProject.em.getTransaction().begin();
		MainProject.em.merge(v);
		MainProject.em.getTransaction().commit();
		System.out.println("Vehicle was correctly updated");
	}
	
	
}
