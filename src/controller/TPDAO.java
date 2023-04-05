package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import model.Subscription;
import model.TravelPasses;
import model.User;
import model.VendingMachine;

public class TPDAO {
	
	public static void saveTicket(TravelPasses tp) {
		MainProject.em.getTransaction().begin();
		MainProject.em.persist(tp);
		MainProject.em.getTransaction().commit();
		System.out.println("Pass was correctly saved in your Tickets/Passes list");
	}
	
	public static void updateTicket(TravelPasses tp) {
		MainProject.em.getTransaction().begin();
		MainProject.em.merge(tp);
		MainProject.em.getTransaction().commit();
		System.out.println("Pass/Ticket was correctly updated");
	}
	
	@SuppressWarnings("unchecked")
	public static void listAllTicketsByDate(LocalDate start, LocalDate end) {
		Query q = MainProject.em.createNamedQuery("TravelPasses.listAllTicketsByDate");
		q.setParameter("start", start);
		q.setParameter("end", end);
		List<TravelPasses> list = q.getResultList();
		System.out.println(list.size() + " tickets was printed between " + start.toString() + " and " + end.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static void listAllTicketsByVendor(VendingMachine vm) {
		Query q = MainProject.em.createNamedQuery("TravelPasses.listAllTicketsByVendor");
		q.setParameter("vm", vm);
		List<TravelPasses> list = q.getResultList();
		System.out.println(list.size() + " tickets was printed from " + vm.toString());
	}
	
	public static TravelPasses getByID(Long id) throws PersistenceException {
		MainProject.em.getTransaction().begin();
		TravelPasses tp = MainProject.em.find(TravelPasses.class, id);
		MainProject.em.getTransaction().commit();
		return tp;
	}
	public static void checkValidity(User u) {
		Query q = MainProject.em.createNamedQuery("Subscription.checkValidity");
		q.setParameter("user", u);
		List<Subscription> list= q.getResultList();
		if(list.size()>0) {
			System.out.println("User has a VALID subscription ");
		}else {
		System.out.println("PAY THE BILL");}
		
	}
	

	
	
	
}
