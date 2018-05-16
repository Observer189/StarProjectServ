package com.example.demo;

public class Player {
    String name;
    String shipName;
    public Player(String name,String shipName)
    {
    	this.name=name;
    	this.shipName=shipName;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
    
}
