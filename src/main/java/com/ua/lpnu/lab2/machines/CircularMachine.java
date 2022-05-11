package com.ua.lpnu.lab2.machines;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CircularMachine extends WoodworkingMachine {

    private int levelOfDanger;

    public CircularMachine(int powerInWatts, double woodVolumePerHour, double priceOfMachine,
                           String manufacturerName, int levelOfDanger) {
        super(powerInWatts, woodVolumePerHour, priceOfMachine, manufacturerName);
        this.levelOfDanger = levelOfDanger;
        super.typeOfWork = TypeOfWork.CIRCULAR;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", level of danger - %d", levelOfDanger);
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",'Danger Level'";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + String.format(",'%d'", levelOfDanger);
    }

}
