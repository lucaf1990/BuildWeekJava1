package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
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
		return "Ticket" + super.toString() + "[check=" + check + ", checkDate=" + checkDate + "]";
	}
	
	
	
}
