package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirFeild;
import com.skilldistillery.jets.entities.FlyingMachine;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerPlane;
import com.skilldistillery.jets.entities.Ufo;

public class FlyingMachineApplication {

	private AirFeild airfeild = new AirFeild();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		FlyingMachineApplication fma = new FlyingMachineApplication();
		
		fma.launch();
		
		fma.kb.close();
	}

	private void launch() {
		boolean keepGoing = true;
		while (keepGoing) {
			int choice = 0;

			displayUserMenu();

			while (choice > 10 || choice < 1) {
				try {
					System.out.print("Enter 1-10: ");
					choice = kb.nextInt();

				} catch (InputMismatchException e) {
					System.err.println("Invalid input, enter 1-10.");
				}
				kb.nextLine();
			}

			switch (choice) {
			case 1:
				airfeild.showAllFlyingMachines();
				break;
			case 2:
				airfeild.flyAllFlyingMachines();
				break;
			case 3:
				airfeild.findFastestFlyingMachine();
				break;
			case 4:
				airfeild.findFurthestFlyingMachine();
				break;
			case 5:
				airfeild.allUfosAbduct();
				break;
			case 6:
				airfeild.loadAllPassengerPlanes();
				break;
			case 7:
				dislayAddMachineMenu();
				break;
			case 8:
				displayRemoveMenu();
				break;
			case 9: 
				System.out.print("\nPlease enter a file name to save machines: ");
				String file = kb.next();
				System.out.println();
				if (file.contains(".txt")) {
					System.err.println("Nothing was saved. Please dont enter \".txt\" only the file name.\n ");
					
					break;
				}
				file = file + ".txt";
				airfeild.saveFlyingMachinesToFile(file);
				break;
			case 10:
				keepGoing = false;
				break;
			default:
				System.out.println("Something went wrong");
			}
		}

	}

	private void displayUserMenu() {
		System.out.println("Plese choose from the following: ");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all machines");
		System.out.println("3. View the fastest machine");
		System.out.println("4. View machine with Longest range");
		System.out.println("5. All UFOs Abduct!");
		System.out.println("6. Board all passenger planes");
		System.out.println("7. Add flying machine to fleet");
		System.out.println("8. Remove flying machine from fleet");
		System.out.println("9. Save flying machines to file");
		System.out.println("10. Quit");
	}

	private void dislayAddMachineMenu() {

		int choice = 0;
		System.out.println();
		System.out.println("Select the type of Flying Machine you would like to add: ");
		System.out.println("1. UFO");
		System.out.println("2. Jet");
		System.out.println("3. Passenger Plane");
		System.out.println("4. Quit");

		while (choice < 1 || choice > 4) {
			System.out.println("Please enter 1-4");

			try {
				choice = kb.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid input, must enter number. No machines added ");

			}
			kb.nextLine();
		}

		if (choice == 4) {
			return;
		} else if (choice < 1 || choice > 4) {
			System.err.println("Invalid input, must enter 1-4. No machines added ");
			return;
		}

		System.out.print("Please enter model:  ");
		String model = kb.nextLine();

		// User Prompt
		double speed = 0.0;

		while (speed == 0.0) {
			try {
				System.out.print("Speed: ");
				speed = kb.nextDouble();
			} catch (InputMismatchException e) {
				System.err.println("Please enter a valid double. ex: 125.2");
			}
			kb.nextLine();
		}

		// User Prompt
		int range = 0;

		while (range == 0) {
			try {
				System.out.print("Range: ");
				range = kb.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Plese enter a valid number, ex: 300");
			}
			kb.nextLine();
		}

		// User Prompt
		long price = 0;

		while (price == 0) {
			try {
				System.out.print("Price: ");
				price = kb.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("Plese enter a valid number, ex: 700000");
			}
			kb.nextLine();
		}

		switch (choice) {
		case 1:
			FlyingMachine ufo = new Ufo(model, speed, range, price);
			airfeild.addFlyingMachine(ufo);
			break;
		case 2:
			FlyingMachine jet = new Jet(model, speed, range, price);
			airfeild.addFlyingMachine(jet);
			break;
		case 3:
			FlyingMachine pp = new PassengerPlane(model, speed, range, price);
			airfeild.addFlyingMachine(pp);
			break;

		default:
			System.out.println("Something went wrong!");
		}

	}

	public void displayRemoveMenu() {
		
		System.out.println();
		System.out.println("Select the Flying Machine to remove ");
		System.out.println("Enter the model to remove:");
		System.out.println();
		airfeild.showAllFlyingMachines();
		System.out.println();
		System.out.println("Enter \"Quit\" to quit.");

		String choice = kb.nextLine();

		if (choice.equalsIgnoreCase("quit")) {
			return;
		}

		List<FlyingMachine> machinesArr = airfeild.getMachineArr();
		int arrSizeBeforeRemoval = machinesArr.size();

		for (int i = 0; i < machinesArr.size(); i++) {
			if (choice.equalsIgnoreCase(machinesArr.get(i).getModel())) {
				System.out.println(machinesArr.get(i).getModel() + " was removed");
				System.out.println();
				airfeild.removeFlyingMachine(i);
			}
		}

		if (arrSizeBeforeRemoval == machinesArr.size()) {
			System.out.println("No Machines were removed, invalid choice");
			System.out.println();
		}
	}

}
