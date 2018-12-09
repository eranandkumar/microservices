package com.springboot.microservices.limitservice.bean;

public class LimitConfigration {
	private int maximum;
	private int minimum;
	
	public LimitConfigration() {
		
	}
	
	public LimitConfigration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
}
