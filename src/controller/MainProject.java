package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import connector.JpaUtil;
import model.Vehicle;

public class MainProject {

	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("!!!CONNECTION ESTABILISHED");
		System.out.println("\n\t >>GESTIONALE TRENITALIA (104 S.p.A.)");

		while (true) {
			try {
				checkService();
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

	public static void checkService() {
		System.out.println("\n>CHECKING VEHICLES MAINTENANCE STATUS");
		List<Vehicle> vList = VDAO.findAllFS();
		if (vList.size() > 0) {
			vList.forEach(v -> {
				if (v.getMaintenance_start().isAfter(LocalDate.now())
						|| v.getMaintenance_end().isBefore(LocalDate.now())) {
					v.setIn_service(true);
					VDAO.updateVeichle(v);
				} else {
					v.setIn_service(false);
					VDAO.updateVeichle(v);
				}
			});
		} else {
			System.out.println("No vehicles found or no maintenance dates setted.");
		}
		System.out.println(">CHECKING VEHICLES MAINTENANCE STATUS UPDATED\n");
	}

}
