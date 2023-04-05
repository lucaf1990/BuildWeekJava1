package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Vehicle_type v_type;
	
	@Column(nullable = false)
	private int capacity;
	
	@Column(nullable = false)
	private boolean in_service;
	
	@ManyToOne
	private Route route;
	
	private Long count = 0l;
	
	private LocalDate maintenance_start = null;
	private LocalDate maintenance_end = null;
	
	public Vehicle() {
	}
	
	public Vehicle(Vehicle_type vehicle_type, int capacity) {
		this.v_type = vehicle_type;
		this.in_service = true;
	}

	public Vehicle(Vehicle_type vehicle_type, boolean in_service, LocalDate maintenance_start,
			LocalDate maintenance_end) {
		this.v_type = vehicle_type;
		this.in_service = in_service;
		this.maintenance_start = maintenance_start;
		this.maintenance_end = maintenance_end;
	}

	public Vehicle_type getV_type() {
		return v_type;
	}

	public void setV_type(Vehicle_type v_type) {
		this.v_type = v_type;
		if (v_type.equals(Vehicle_type.BUS)) {
			setCapacity(50);
		} else {
			setCapacity(100);
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isIn_service() {
		return in_service;
	}

	public void setIn_service(boolean in_service) {
		this.in_service = in_service;
	}

	public LocalDate getMaintenance_start() {
		return maintenance_start;
	}

	public void setMaintenance_start(LocalDate maintenance_start) {
		this.maintenance_start = maintenance_start;
	}

	public LocalDate getMaintenance_end() {
		return maintenance_end;
	}

	public void setMaintenance_end(LocalDate maintenance_end) {
		this.maintenance_end = maintenance_end;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Long getId() {
		return id;
	}

	public Long getCount() {
		return count;
	}

	public void addCount() {
		this.count++;
	}
}
