package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirFeild {
	private List<FlyingMachine> machineArr  = new ArrayList<>();
	
	
	
	public AirFeild() {
		super();
		try ( BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt")) ) {
			  String line;
			  while ((line = bufIn.readLine()) != null) {
			    
				  String [] temp = line.split(",");
			    //checks first Index of arr for matching FlyingMahcine subclasses
			    if (temp[0].equals("Ufo")) {
			    	FlyingMachine ufo = new Ufo(temp[1],Double.parseDouble(temp[2]),
			    			Integer.parseInt(temp[3]), Long.parseLong(temp[4]));
			    	machineArr.add(ufo);
			    } else if (temp[0].equals("Passenger Plane")) {
			    	FlyingMachine passplane = new PassengerPlane(temp[1],Double.parseDouble(temp[2]),
			    			Integer.parseInt(temp[3]), Long.parseLong(temp[4]));
			    	machineArr.add(passplane);
			    } else if (temp[0].equals("Jet")) {
			    	FlyingMachine jet = new Jet(temp[1],Double.parseDouble(temp[2]),
			    			Integer.parseInt(temp[3]), Long.parseLong(temp[4]));
			    	machineArr.add(jet);	
			    }
			    
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
	}
	
	
	
	
	public List<FlyingMachine> getMachineArr() {
		return machineArr;
	}




	public void setMachineArr(List<FlyingMachine> machineArr) {
		this.machineArr = machineArr;
	}




	public void addFlyingMachine(FlyingMachine fm) {
		machineArr.add(fm);
	}
	
	
	public void removeFlyingMachine(int machine) {
		machineArr.remove(machine);
	}
	
	
	public void showAllFlyingMachines() {
		
		for (int i = 0; i < machineArr.size(); i++) {
			System.out.println(machineArr.get(i));
			System.out.println();
		}
	}
	
	public void flyAllFlyingMachines() { 
		for (int i = 0; i < machineArr.size(); i++) {
			
			machineArr.get(i).fly();
			System.out.println();
			}
	}
	
	
	public void findFastestFlyingMachine() {
		FlyingMachine fastest = machineArr.get(0);
		for (int i = 0; i < machineArr.size(); i++) {
			if (machineArr.get(i).getSpeed() > fastest.getSpeed()) {
				fastest = machineArr.get(i);
			}
		}
		
		System.out.println("Fastest Flying Machine: ");
		System.out.println(fastest);
		System.out.println();
	
	}
	
	
	public void findFurthestFlyingMachine() {
		
		FlyingMachine furthest = machineArr.get(0);
		for (int i = 0; i < machineArr.size(); i++) {
			if (machineArr.get(i).getRange() > furthest.getRange()) {
				furthest = machineArr.get(i);
			}
		}
		
		System.out.println("Furthest Flying Machine: ");
		System.out.println(furthest);
		System.out.println();
		
	}
	
	public void allUfosAbduct() {
		for (int i = 0; i < machineArr.size(); i++) {
			if (machineArr.get(i) instanceof Ufo ) {
				
				Ufo ufo = (Ufo) machineArr.get(i);
				ufo.abductHumans();
				System.out.println();
			}
		}
	}
	
	public void loadAllPassengerPlanes() {
		for (int i = 0; i < machineArr.size(); i++) {
			if (machineArr.get(i) instanceof PassengerPlane ) {
				
				PassengerPlane pp = (PassengerPlane) machineArr.get(i);
				pp.loadPassengers();
				System.out.println();
			}
		}
	}
	
}
