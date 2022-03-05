package com.skilldistillery.jets.entities;

public class PassengerPlane extends FlyingMachine implements LoadPlane {

	public PassengerPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	
	public void loadPassengers() {
		int passengers = (int)((Math.random() * 100) + 34);
		int flightNumber = (int)((Math.random() * 1000) + 2);
		System.out.println("Now boarding flight " + flightNumber);
		System.out.println("We have " + passengers + " passengers on this flight today");
	}
		
}
