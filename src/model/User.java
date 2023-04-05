package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private LocalDate pass_emi;
	@Column(nullable = false)
	private LocalDate pass_exp;
	
	public User() {
	}

	public User(String name, String surname, LocalDate emi) {
		this.name = name;
		this.surname = surname;
		this.setPass_emi(emi);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getPass_emi() {
		return pass_emi;
	}

	public void setPass_emi(LocalDate pass_emi) {
		this.pass_emi = pass_emi;
		this.pass_exp = pass_emi.plusYears(1);
	}

	public LocalDate getPass_exp() {
		return pass_exp;
	}

	public void setPass_exp(LocalDate pass_exp) {
		this.pass_exp = pass_exp;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", pass_emi=" + pass_emi + ", pass_exp="
				+ pass_exp + "]";
	}

}
