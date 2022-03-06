package com.skilldistillery.jets.entities;

public class Ufo extends FlyingMachine implements Abduct {

	public Ufo(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
		
	public void abductHumans() {
		int random = (int)(Math.random() * 100);
		System.out.println(random + " humans obducted hahaha!");
	}
	

}
