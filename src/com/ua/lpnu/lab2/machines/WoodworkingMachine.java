package com.ua.lpnu.lab2.machines;

import com.ua.lpnu.lab2.enums.TypeOfWork;

public abstract class WoodworkingMachine {

    private String manufacturerName;
    private int powerInWatts;
    private double woodVolumePerHour;
    private double priceOfMachine;
    TypeOfWork typeOfWork;

    public WoodworkingMachine(int powerInWatts, double woodVolumePerHour, double priceOfMachine, String manufacturerName) {
        this.powerInWatts = powerInWatts;
        this.woodVolumePerHour = woodVolumePerHour;
        this.priceOfMachine = priceOfMachine;
        this.manufacturerName = manufacturerName;
    }

    public int getPowerInWatts() {
        return powerInWatts;
    }

    public void setPowerInWatts(int powerInWatts) {
        this.powerInWatts = powerInWatts;
    }

    public double getWoodVolumePerHour() {
        return woodVolumePerHour;
    }

    public void setWoodVolumePerHour(double woodVolumePerHour) {
        this.woodVolumePerHour = woodVolumePerHour;
    }

    public double getPriceOfMachine() {
        return priceOfMachine;
    }

    public void setPriceOfMachine(double priceOfMachine) {
        this.priceOfMachine = priceOfMachine;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public TypeOfWork getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(TypeOfWork typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    @Override
    public String toString() {
        return String.format("Manufacturer name - %s, VPM - %.1f, power - %d, "+
                        "price - %.1f, type of work - %s", manufacturerName, woodVolumePerHour, powerInWatts,
                priceOfMachine, typeOfWork);
    }
}
