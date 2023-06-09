package controller;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public static List<VendingMachine> findAll() {
		Query q = MainProject.em.createNamedQuery("VendingMachine.findAll");
		return q.getResultList();
	}
	
}
