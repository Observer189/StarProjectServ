package com.example.demo;

public class ServFixingPoint {
    private ServWeapon weapon;
    public ServFixingPoint()
    {

    }
    public ServFixingPoint(ServWeapon weapon)
    {
        this.weapon=weapon;
    }
    public ServFixingPoint(ServFixingPoint servFixingPoint)
    {
        weapon=servFixingPoint.getWeapon();
    }

    public ServWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(ServWeapon weapon) {
        this.weapon = weapon;
    }
}