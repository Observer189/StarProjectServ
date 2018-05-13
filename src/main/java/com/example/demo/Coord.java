package com.example.demo;

public class Coord {
    private Float x;
    private Float y;
    public Coord()
        {

    }
    public Coord(Float x,Float y)
    {
        this.x=x;
        this.y=y;
    }
    public Coord(Coord coord)
    {
    	x=coord.getX();
    	y=coord.getY();
    }
    public void setX(float x)
    {
        this.x=x;
    }
    public void setY(float y)
    {
        this.y=y;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }
}
