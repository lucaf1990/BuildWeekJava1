package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity

public class Subscription extends TravelPasses {
	
	@Enumerated(EnumType.ORDINAL)
	private DurationType duration;

	private LocalDate sub_exp; 
	@ManyToOne
	private User user;
	
	public DurationType getDuration() {
		return duration;
	}
	
	public void setDuration(DurationType duration) {
		this.duration = duration;
		if(duration.equals(DurationType.Weekly)) {
			setSub_exp(this.getEmitted().plusDays(7));
		} else {
			setSub_exp(this.getEmitted().plusDays(30));
		}
	}
	
	public LocalDate getSub_exp() {
		return sub_exp;
	}
	public void setSub_exp(LocalDate sub_exp) {
		this.sub_exp = sub_exp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Subscription" + super.toString() + "[duration=" + duration + ", sub_exp=" + sub_exp + ", user=" + user + "]";
	}
	
}
