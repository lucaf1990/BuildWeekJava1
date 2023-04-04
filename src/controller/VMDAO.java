package controller;

import javax.persistence.PersistenceException;

import model.VendingMachine;

public class VMDAO {

	
	public static void saveVendingMachine(VendingMachine vm) {
		MainProject.em.getTransaction().begin();
		MainProject.em.persist(vm);
		MainProject.em.getTransaction().commit();
		System.out.println("VendingMachine was correctly started");
	}
	
	public static void updateVendingMachine(VendingMachine vm) {
		MainProject.em.getTransaction().begin();
		MainProject.em.merge(vm);
		MainProject.em.getTransaction().commit();
		System.out.println("VendingMachine was correctly updated");
	}
	
	public static VendingMachine getByID(Long id) throws PersistenceException {
		MainProject.em.getTransaction().begin();
		VendingMachine vm = MainProject.em.find(VendingMachine.class, id);
		MainProject.em.getTransaction().commit();
		return vm;
	}
	
}
