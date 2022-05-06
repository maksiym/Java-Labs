package com.ua.lpnu.lab2.machines;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ReymusMachine extends WoodworkingMachine {

    private int numberOfTypes;

    public ReymusMachine(int powerInWatts, double woodVolumePerHour, double priceOfMachine,
                         String manufacturerName, int numberOfTypes) {
        super(powerInWatts, woodVolumePerHour, priceOfMachine, manufacturerName);
        this.numberOfTypes = numberOfTypes;
        super.typeOfWork = TypeOfWork.REYMUS;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", number of types - %d", numberOfTypes);
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + ",'Types'";
    }

    @Override
    public String toCSV () {
        return super.toCSV() + String.format(",'%d'", numberOfTypes);
    }

}
