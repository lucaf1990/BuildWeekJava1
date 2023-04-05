package controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import connector.JpaUtil;

public class MainProject {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("!!!CONNECTION ESTABILISHED");	
		System.out.println("\n\t >>GESTIONALE TRENITALIA (104 S.p.A.)");
		
		while (true) {
			try {
				Menu.MainMenu();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public static LocalDate genDate() {		
		System.out.println("Insert YEAR (YYYY)");
		int year = MainProject.scan.nextInt();
		System.out.println("Insert MONTH (MM)");
		int month = MainProject.scan.nextInt();
		System.out.println("Insert DAY (DD)");
		int day = MainProject.scan.nextInt();
		MainProject.scan.nextLine();
		return LocalDate.of(year, month, day);
	}


}
