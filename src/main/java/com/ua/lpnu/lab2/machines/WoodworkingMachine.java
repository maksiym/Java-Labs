package com.ua.lpnu.lab2.machines;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class WoodworkingMachine {

    private String manufacturerName;
    private int powerInWatts;
    private double woodVolumePerHour;
    private double priceOfMachine;
    TypeOfWork typeOfWork;

    protected WoodworkingMachine(int powerInWatts, double woodVolumePerHour, double priceOfMachine, String manufacturerName) {
        this.powerInWatts = powerInWatts;
        this.woodVolumePerHour = woodVolumePerHour;
        this.priceOfMachine = priceOfMachine;
        this.manufacturerName = manufacturerName;
    }

    @Override
    public String toString() {
        return String.format("Manufacturer name - %s, VPM - %.1f, power - %d, "+
                        "price - %.1f, type of work - %s", manufacturerName, woodVolumePerHour, powerInWatts,
                priceOfMachine, typeOfWork);
    }
}
