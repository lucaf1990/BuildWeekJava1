package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import connector.JpaUtil;

public class main {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("connected");
	}

}
