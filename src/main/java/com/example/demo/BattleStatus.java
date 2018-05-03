package com.example.demo;

public class BattleStatus { //класс необходимый для распределения игроков по боям
    Integer number;
    String status;
    public BattleStatus()
    {
        
    }
    public BattleStatus(Integer number,String status)
    {
       this.number=number;
       this.status=status;
    }

    public void setNumber(Integer battleNumber) {
        this.number = battleNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }
}
