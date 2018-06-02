package com.example.demo;

public class Player {
    String name;
    String password;
    int money;
    ServShip ship;
    long lastRequestTime;
    public Player() {}

    public Player(String name,ServShip ship)
    {
    	this.name=name;
    	this.ship=new ServShip(ship);
    }
    public Player(String name,String password,int money,ServShip ship)
    {
    	this.name=name;
    	this.password=password;
    	this.money=money;
    	this.ship=ship;
    	lastRequestTime=System.currentTimeMillis();
    }
    
    public long getLastRequestTime() {
		return lastRequestTime;
	}

	public void setLastRequestTime(long lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ServShip getShip() {
		return ship;
	}
	public void setShip(ServShip ship) {
		this.ship = ship;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
    
}
