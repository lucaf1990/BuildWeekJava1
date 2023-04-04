package controller;

import java.time.LocalDate;

import model.DurationType;
import model.Subscription;
import model.User;
import model.VendingMachine;

public class Menu {

	public static void MainMenu() throws Exception {
		System.out.println("\n\t >>MAIN MENU\n");
		System.out.println("\t\t 1 - CREATE");
		System.out.println("\t\t 0 - EXIT");
		System.out.print("\n\t >>SELECT AN ACTION: ");
		int scelta = MainProject.scan.nextInt();
		switch (scelta) {
		case 0 -> {
			System.out.println("Copyright 104 SpA - All Rights Reserved");
			System.exit(0);
		}
		case 1 -> {
			System.out.print("\n\t >>CREATE NEW...:\n");
			System.out.println("\t\t 1 - USER");
			System.out.println("\t\t 2 - SUBSCRIPTION");
			System.out.println("\t\t 3 - TICKET");
			System.out.println("\t\t 4 - VEICHLE");
			System.out.println("\t\t 5 - VENDING MACHINE");
			System.out.println("\t\t 6 - TRIP");
			int scelta1 = MainProject.scan.nextInt();
			switch (scelta1) {
			case 1 -> {
				MainProject.scan.nextLine();
				System.out.println(">NEW USER: Insert user name");
				String name = MainProject.scan.nextLine();
				System.out.println(">NEW USER: Insert user surname");
				String surname = MainProject.scan.nextLine();
				System.out.println(">NEW USER: Insert emission date");
				LocalDate emitted = MainProject.genDate();
				User utente = new User(name, surname, emitted);
				UserDAO.saveUser(utente);
			}
			case 2 -> {
				MainProject.scan.nextLine();
				Subscription s1 = new Subscription();
				System.out.print(">NEW SUBSCRIPTION: Insert vending machine id");
				Long vmid = MainProject.scan.nextLong();
				VendingMachine vm = VMDAO.getByID(vmid);
				if (vm.isActive()) {
					s1.setDistributor(vm);
				} else {
					System.out.println("Vending Machine out of order or Dealer Acquired");
				}
				System.out.println(">NEW SUBSCRIPTION: Insert emission date");
				LocalDate emitted = MainProject.genDate();
				s1.setEmitted(emitted);
				System.out.print(">NEW SUBSCRIPTION: Subscription duration: (1-WEEKLY - 2-MONTHLY)");
				int dur = MainProject.scan.nextInt();
				MainProject.scan.nextLine();
				switch (dur) {
				case 1:
					s1.setDuration(DurationType.Weekly);
					break;
				case 2:
					s1.setDuration(DurationType.Monthly);
					break;
				default:
					System.out.println("Not valid: assuming Weekly Subscription");
					s1.setDuration(DurationType.Weekly);
				}
				System.out.print(">NEW SUBSCRIPTION: Insert user pass no.:");
				Long uid = MainProject.scan.nextLong();
				User u = UserDAO.getByID(uid);
				TPDAO.saveTicket(s1);
			}
			}

		}
		default -> {
			System.out.println("Action not allowed, try again!");
		}

		}
	}

}
