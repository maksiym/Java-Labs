package com.ua.lpnu.lab2.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.*;

public class WoodworkingMachinesStore {


    private List<WoodworkingMachine> storeMachines = new ArrayList<>();
    private List<WoodworkingMachine> searchResult;

    public WoodworkingMachinesStore(List<WoodworkingMachine> storeMachines) {
            this.storeMachines = storeMachines;
    }

    public WoodworkingMachinesStore() {

    }

    public void addMachineToStore(WoodworkingMachine machine) {
            storeMachines.add(machine);
    }

    public List<WoodworkingMachine> findMachineByBrandAndType (TypeOfWork type, String manufacturerName) {
        searchResult = storeMachines.stream()
                .filter(machine->machine.getTypeOfWork().equals(type))
                .filter(machine->machine.getManufacturerName().equals(manufacturerName))
                .collect(Collectors.toList());
        return searchResult;
    }

    public List<WoodworkingMachine> sortByPower (boolean ascending) {
        if (ascending) {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getPowerInWatts))
                    .collect(Collectors.toList());
        } else {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getPowerInWatts).reversed())
                    .collect(Collectors.toList());
        }
        return searchResult;
    }

    public List<WoodworkingMachine> sortByVolumePerHour (boolean ascending) {
        if (ascending) {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getWoodVolumePerHour))
                    .collect(Collectors.toList());
        } else {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getWoodVolumePerHour).reversed())
                    .collect(Collectors.toList());
        }
        return searchResult;
    }


}





