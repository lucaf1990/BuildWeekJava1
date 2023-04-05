package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="tickets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "TravelPasses.findAll", query = "SELECT tp FROM TravelPasses tp")
@NamedQuery(name = "TravelPasses.listAllTicketsByDate", query = "SELECT tp FROM TravelPasses tp WHERE tp.emitted BETWEEN :start AND :end")
@NamedQuery(name = "TravelPasses.listAllTicketsByVendor", query = "SELECT tp FROM TravelPasses tp WHERE tp.distributor = :vm")
@NamedQuery(name = "Subscription.checkValidity", query = "SELECT s FROM Subscription s WHERE s.user = :user AND current_date < s.sub_exp")
public abstract class TravelPasses implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDate emitted;
	
	@ManyToOne
	private VendingMachine distributor;
	
	public LocalDate getEmitted() {
		return emitted;
	}
	public void setEmitted(LocalDate emitted) {
		this.emitted = emitted;
	}
	public VendingMachine getDistributor() {
		return distributor;
	}
	public void setDistributor(VendingMachine distributor) {
		this.distributor = distributor;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "TravelPasses [id=" + id + ", emitted=" + emitted + ", distributor=" + distributor + "]";
	}
	
	
}
