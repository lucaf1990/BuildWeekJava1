package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
@NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String departure;
	
	@Column(nullable = false)
	private String terminus;
	
	@Column(nullable = false)
	private int travel_time;
	
	public Route() {
	}
	
	public Route(String departure, String terminus, int travel_time) {
		this.departure = departure;
		this.terminus = terminus;
		this.travel_time = travel_time;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getTerminus() {
		return terminus;
	}

	public void setTerminus(String terminus) {
		this.terminus = terminus;
	}

	public int getTravel_time() {
		return travel_time;
	}

	public void setTravel_time(int travel_time) {
		this.travel_time = travel_time;
	}

	public Long getId() {
		return id;
	}
	

}
