package com.example.demo;

public class Player {
    String name;
    int money;
    String shipName;
    public Player() {}

    public Player(String name,String shipName)
    {
    	this.name=name;
    	this.shipName=shipName;
    }
    public Player(String name,int money,String shipName)
    {
    	this.name=name;
    	this.money=money;
    	this.shipName=shipName;
    }
    
    @Override
    public boolean equals(Object obj) {
    	return ((Player)obj).name.equals(name);
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
    
}
