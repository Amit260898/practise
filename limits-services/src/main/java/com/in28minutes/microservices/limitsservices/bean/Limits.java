package com.in28minutes.microservices.limitsservices.bean;

public class Limits {
	private int minimum;
	private int maximum;
	
	public Limits() {
		super();
	}
	
	public Limits(int minimum, int maximum) {
		// TODO Auto-generated constructor stub
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
