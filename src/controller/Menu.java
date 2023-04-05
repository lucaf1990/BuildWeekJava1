package controller;

import java.time.LocalDate;
import java.util.List;

import model.DurationType;
import model.Route;
import model.Subscription;
import model.TravelPasses;
import model.Ticket;
import model.User;
import model.Vehicle;
import model.Vehicle_type;
import model.VendingMachine;

public class Menu {

	public static void MainMenu() throws Exception {
		System.out.println("\n\t >>MAIN MENU\n");
		System.out.println("\t\t 1 - CREATE");
		System.out.println("\t\t 2 - VEHICLES MANAGEMENT");
		System.out.println("\t\t 3 - TP-MANAGEMENT");
		System.out.println("\t\t 4 - SHOW ALL LISTS");
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
			System.out.println("\t\t 6 - ROUTE");
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
				if (vm != null) {
					if (vm.isActive()) {
						s1.setDistributor(vm);

					} else {
						System.out.println("Vending machine out of order setting Dealer acquired");
					}

				} else {
					System.out.println("Vending Machine not found or Dealer Acquired");
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
			case 3 -> {

				MainProject.scan.nextLine();
				Ticket t1 = new Ticket();
				System.out.print(">NEW TICKET: Insert vending machine id");
				Long vmid = MainProject.scan.nextLong();
				VendingMachine vm = VMDAO.getByID(vmid);
				if (vm != null) {
					if (vm.isActive()) {
						t1.setDistributor(vm);

					} else {
						System.out.println("Vending machine out of order setting Dealer acquired");
					}

				} else {
					System.out.println("Vending Machine not found or Dealer Acquired");
				}
				System.out.println(">NEW SUBSCRIPTION: Insert emission date");
				LocalDate emitted = MainProject.genDate();
				t1.setEmitted(emitted);
				TPDAO.saveTicket(t1);

			}
			case 4 -> {

				MainProject.scan.nextLine();
				Vehicle v1 = new Vehicle();
				System.out.println(">NEW VEHICLE: Insert type: ");
				System.out.println("\t\t 1 - BUS");
				System.out.println("\t\t 2 - TRAM");
				int vt = MainProject.scan.nextInt();
				MainProject.scan.nextLine();
				if (vt == 1) {
					v1.setV_type(Vehicle_type.BUS);

				} else {
					v1.setV_type(Vehicle_type.TRAM);
				}
				v1.setIn_service(true);
				VDAO.saveVehicle(v1);
			}
			case 5 -> {
				MainProject.scan.nextLine();
				System.out.print(">NEW VENDING MACHINE: Insert status: ");
				boolean vm = MainProject.scan.nextBoolean();
				VendingMachine vm1 = new VendingMachine();
				vm1.setActive(vm);
				VMDAO.saveVendingMachine(vm1);

			}
			case 6 -> {
				MainProject.scan.nextLine();
				System.out.print(">NEW ROUTE: Starts from:  ");
				String sp = MainProject.scan.nextLine();
				System.out.print(">NEW ROUTE: Ends at:  ");
				String ep = MainProject.scan.nextLine();
				System.out.print(">NEW ROUTE: Duration(min):  ");
				int dur = MainProject.scan.nextInt();
				MainProject.scan.nextLine();
				Route r1 = new Route(sp, ep, dur);
				RODAO.saveRoute(r1);
			}
			}
		}
		case 2 -> {
			System.out.print("\n\t >>VEHICLE MANAGEMENT:\n");
			System.out.println("\t 1 - ASSIGN ROUTE TO VEHICLE");
			System.out.println("\t 2 - SEND VEHICLE TO MAINTENANCE");
			System.out.println("\t 3 - ADD RUN");
			System.out.println("\t 4 - CHECK TOTAL RUNTIME");
			int scelta2 = MainProject.scan.nextInt();
			switch (scelta2) {
			case 1 -> {
				MainProject.scan.nextLine();
				System.out.print(">INSERT VEHICLE ID:  ");
				Long idV = MainProject.scan.nextLong();
				Vehicle v = VDAO.getByID(idV);
				if (v.isIn_service()) {
					System.out.print(">INSERT ROUTE ID:  ");
				Long idR = MainProject.scan.nextLong();
				Route r = RODAO.getByID(idR);

				v.setRoute(r);
				VDAO.updateVeichle(v);
				} else {
					System.out.println("Vehicle out of order!");
				}
				
			}
			case 2 -> {
				MainProject.scan.nextLine();
				System.out.print(">SELECT A VEHICLE (INSERT ID):  ");
				Long idV = MainProject.scan.nextLong();
				Vehicle v = VDAO.getByID(idV);

				System.out.println(">INSERT THE MAINTENANCE START DATE:  ");
				LocalDate maintStart = MainProject.genDate();
				System.out.println(">INSERT THE MAINTENANCE END DATE:  ");
				LocalDate maintEnd = MainProject.genDate();

				v.setMaintenance_start(maintStart);
				v.setMaintenance_end(maintEnd);
				VDAO.updateVeichle(v);
			}
			case 3 -> {
				System.out.print(">SELECT A VEHICLE (INSERT ID):  ");
				Long idV = MainProject.scan.nextLong();
				Vehicle v = VDAO.getByID(idV);
				if (v.getRoute() != null) {
				v.addCount();
				VDAO.updateVeichle(v);
				} else {
					System.out.println("No routes assigned to veichle");
				}
			}
			case 4 -> {
				System.out.print(">SELECT A VEHICLE (INSERT ID):  ");
				Long idV = MainProject.scan.nextLong();
				Vehicle v = VDAO.getByID(idV);
				if (v.getRoute() != null) {
					Route r = v.getRoute();
					long total = r.getTravel_time() * v.getCount();
					System.out.println("Total travel time for vehicle" + v.getId() + ", is " + total + " mins.");
					} else {
						System.out.println("No routes assigned to veichle");
					}
			}
			default -> {System.out.println("Invalid selection, try again!");}
			}
		}
		case 3 -> {
			System.out.print("\n\t >>TR-PASSES MANAGEMENT:\n");
			System.out.println("\t 1 - VERIFY YOUR MEMBERSHIP RENEWAL");
			System.out.println("\t 2 - VERIFY YOUR EMITTED TP BY DATE");
			System.out.println("\t 3 - VERIFY YOUR EMITTED TP BY SELLING MACHINE");
			System.out.println("\t 4 - OBLITERATE TICKET");
			System.out.println("\t 5 - CHECK TICKET");
			System.out.println("\t 6 - GET TICKETS OBLITERATED ON A CERTAIN TIMELAPSE");
			System.out.println("\t 7 - GET TICKETS OBLITERATED ON A CERTAIN VEHICLE");
			int scelta3 = MainProject.scan.nextInt();
			switch (scelta3) {

			case 1 -> {
				MainProject.scan.nextLine();
				System.out.print(">INSERT USER ID:  ");
				Long idV = MainProject.scan.nextLong();
				User u = UserDAO.getByID(idV);
				if (u.getPass_exp().isAfter(LocalDate.now())) {
					TPDAO.checkValidity(u);
				} else {
					System.out.println("Membership expired");
				}
			}
			case 2 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT START DATE:  ");
				LocalDate tpStart = MainProject.genDate();
				System.out.println(">INSERT END DATE:  ");
				LocalDate tpEnd = MainProject.genDate();
				TPDAO.listAllTicketsByDate(tpStart, tpEnd);
			}
			case 3 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT ID:  ");
				Long idVM = MainProject.scan.nextLong();
				VendingMachine vm = VMDAO.getByID(idVM);
				TPDAO.listAllTicketsByVendor(vm);
			}
			case 4 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT TICKET ID:  ");
				Long tid = MainProject.scan.nextLong();
				Ticket t = (Ticket) TPDAO.getByID(tid);
				if (t.getCheck() == null) {
					System.out.println(">INSERT VEICHLE ID:  ");
					Long vid = MainProject.scan.nextLong();
					Vehicle v = VDAO.getByID(vid);
					if (v.getRoute() != null) {
						t.setCheck(v);
						LocalDate data = MainProject.genDate();
						t.setCheckDate(data);
						TPDAO.updateTicket(t);
					} else {
						System.out.println("Vehicle out of order or not found");
					}
				} else {
					System.out.println("Invalid Ticket");
				}
			}
			case 5 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT TICKET ID:  ");
				Long tid = MainProject.scan.nextLong();
				Ticket t = (Ticket) TPDAO.getByID(tid);
				if (t.getCheck() == null) {
					System.out.println("Ticket is valid!");
				} else {				
					System.out.println("ACCATTITILLU U BIGLIETTU!");
				}
			}
			case 6 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT START DATE:  ");
				LocalDate tpStart = MainProject.genDate();
				System.out.println(">INSERT END DATE:  ");
				LocalDate tpEnd = MainProject.genDate();
				TPDAO.checkedByDate(tpStart, tpEnd);
			}
			case 7 -> {
				MainProject.scan.nextLine();
				System.out.println(">INSERT VEHICLE ID:  ");
				Long idv = MainProject.scan.nextLong();
				Vehicle v = VDAO.getByID(idv);
				TPDAO.checkedByVehicle(v);
			}
			default -> {
				System.out.println("Invalid selection, try again!");
			}
			}
		}
		case 4 -> {
			System.out.println("\n\t >>SHOW ALL LISTS:");
			System.out.println("\t 1 - USERS");
			System.out.println("\t 2 - VENDING MACHINES");
			System.out.println("\t 3 - TRAVEL PASSES");
			System.out.println("\t 4 - VEICHLES");
			System.out.println("\t 5 - ROUTES");
			int scelta4 = MainProject.scan.nextInt();
			switch (scelta4) {
			case 1 -> {
				MainProject.scan.nextLine();
				List<User> users = UserDAO.findAll();
				if (users.size() > 0) {
					users.forEach(el -> System.out.println(el));
					System.out.println("There are " + users.size() + " users in DB.");
				} else {
					System.out.println("No users found");
				}
			}
			case 2 -> {
				MainProject.scan.nextLine();
				List<VendingMachine> vms = VMDAO.findAll();
				if (vms.size() > 0) {
					vms.forEach(el -> System.out.println(el));
					System.out.println("There are " + vms.size() + " VendingMachines in DB.");
				} else {
					System.out.println("No Vending Machines found");
				}
			}
			case 3 -> {
				MainProject.scan.nextLine();
				List<TravelPasses> tpss = TPDAO.findAll();
				if (tpss.size() > 0) {
					tpss.forEach(el -> System.out.println(el));
					System.out.println("There are " + tpss.size() + " TravelPAsses in DB.");
				} else {
					System.out.println("No TravelPAsses found");
				}
			}
			case 4 -> {
				MainProject.scan.nextLine();
				List<Vehicle> vhs = VDAO.findAll();
				if (vhs.size() > 0) {
					vhs.forEach(el -> System.out.println(el));
					System.out.println("There are " + vhs.size() + " vehicles in DB.");
				} else {
					System.out.println("No vehicles found");
				}
			}
			case 5 -> {
				MainProject.scan.nextLine();
				List<Route> rts = RODAO.findAll();
				if (rts.size() > 0) {
					rts.forEach(el -> System.out.println(el));
					System.out.println("There are " + rts.size() + " routes in DB.");
				} else {
					System.out.println("No routes found");
				}
			}
			default -> {System.out.println("Action not allowed, try again!");}
			}
		}
		default -> {
			System.out.println("Action not allowed, try again!");
		}

		}
	}

}
