package com.example.demo;

public class BattleStatus { //класс необходимый для распределения игроков по боям
    Integer number;
    String status;
    String name;
    String shipName;
    Integer queueSize;//размер очереди
    Integer positionNumber; //номер позиции игрока на карте
    public BattleStatus()
    {

    }
    public BattleStatus(Integer number,Integer queueSize,String name,String shipName,String status,Integer positionNumber)
    {
        this.number=number;
        this.queueSize=queueSize;
        this.name=name;
        this.shipName=shipName;
        this.status=status;
        this.positionNumber=positionNumber;
    }
    public BattleStatus(BattleStatus battleStatus)
    {
        this.status=battleStatus.getStatus();
        this.number=battleStatus.getNumber();
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
    public void setBattleStatus(BattleStatus battleStatus)
    {
        this.setStatus(battleStatus.getStatus());
        this.setQueueSize(battleStatus.getQueueSize());
        this.name=battleStatus.getName();
        this.shipName=battleStatus.getShipName();
        this.setNumber(battleStatus.getNumber());
        this.setPositionNumber(battleStatus.getPositionNumber());
    }

    public Integer getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }

    public void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    public Integer getPositionNumber() {
        return positionNumber;
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


