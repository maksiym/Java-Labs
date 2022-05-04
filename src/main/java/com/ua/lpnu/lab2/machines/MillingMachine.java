package com.ua.lpnu.lab2.machines;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MillingMachine extends WoodworkingMachine {

    private String typeOfControl;

    public MillingMachine(int powerInWatts, double woodVolumePerHour, double priceOfMachine,
                          String manufacturerName, String typeOfControl) {
        super(powerInWatts, woodVolumePerHour, priceOfMachine, manufacturerName);
        this.typeOfControl = typeOfControl;
        super.typeOfWork = TypeOfWork.MILLING;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(", type of control - %s", typeOfControl);
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + "Control Type;";
    }

    @Override
    public String toCSV () {
        return super.toCSV() + getTypeOfControl() + ";";
    }


}
