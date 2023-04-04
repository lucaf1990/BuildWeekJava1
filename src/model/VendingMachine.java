package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="machine")
public class VendingMachine implements Serializable {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private boolean active;
		
		
		public Long getId() {
			return id;
		}
	
		public boolean isActive() {
			return active;
		}
		
		public void setActive(boolean active) {
			this.active = active;
		}
		
		@Override
		public String toString() {
			return "VendingMachine [id=" + id + ", active=" + active + "]";
		}
		
}
