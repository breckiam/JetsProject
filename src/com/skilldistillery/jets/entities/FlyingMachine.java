package com.skilldistillery.jets.entities;

public abstract class FlyingMachine {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public FlyingMachine(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	// Getters and Setters

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	// End of Getters and Setters
	
	public void fly() {
		System.out.println(this.toString());
		System.out.println(this.getModel() + " can fly for " + this.flightTime());
	} 
	
	public String flightTime() {
		double time = (this.range / this.speed) * 60;
		int hours = (int) (time / 60);
		int minutes = (int)(time % 60);
		
		if (hours == 0) {
			return minutes + " minutes";
		} else if (minutes == 0) {
			return hours + "hours";
		} else {
			return hours + " hours and " + minutes + " minutes";
			
		}
	}
	
	public String toString() {
		return "Type: " + this.getClass().getSimpleName() + " | Model: " + this.model + " | Speed: " + this.speed + " | Range: " + this.range + " | Price: " + this.price;
	}
	
}
