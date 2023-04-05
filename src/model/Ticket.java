package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Ticket.checkedByDate", query = "SELECT tp FROM Ticket tp WHERE tp.check IS NOT NULL and tp.checkDate BETWEEN :start AND :end")
@NamedQuery(name = "Ticket.checkedByVehicle", query = "SELECT tp FROM Ticket tp WHERE tp.check = :vehicle")
public class Ticket extends TravelPasses {

	@ManyToOne
	private Vehicle check;
	
	private LocalDate checkDate;
	
	public Vehicle getCheck() {
		return check;
	}
	public void setCheck(Vehicle check) {
		this.check = check;
	}
	public LocalDate getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(LocalDate checkDate) {
		this.checkDate = checkDate;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + this.getId() + ", emitted=" + this.getEmitted() + ", distr=" + this.getDistributor() + ", check=" + check + ", checkDate=" + checkDate + "]";
	}
	
	
	
}
