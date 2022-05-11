package com.ua.lpnu.lab2.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import com.ua.lpnu.lab2.enums.TypeOfSort;
import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WoodworkingMachinesStore {

    private List<WoodworkingMachine> storeMachines = new ArrayList<>();
    private List<WoodworkingMachine> searchResult = new ArrayList<>();

    public WoodworkingMachinesStore() {
    }

    public WoodworkingMachinesStore(List<WoodworkingMachine> storeMachines) {
        this.storeMachines = storeMachines;
    }

    public void addMachineToStore(WoodworkingMachine machine) {
        storeMachines.add(machine);
    }

    public List<WoodworkingMachine> findMachineByBrandAndType(TypeOfWork type, String manufacturerName) {
        searchResult = storeMachines.stream()
                .filter(machine -> machine.getTypeOfWork().equals(type))
                .filter(machine -> machine.getManufacturerName().equals(manufacturerName))
                .toList();
        return searchResult;
    }

    public List<WoodworkingMachine> sortByPower(TypeOfSort type) {
        if (TypeOfSort.ASCENDING.equals(type)) {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getPowerInWatts))
                    .toList();
        } else {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getPowerInWatts).reversed())
                    .toList();
        }
        return searchResult;
    }

    public List<WoodworkingMachine> sortByVolumePerHour(TypeOfSort type) {
        if (TypeOfSort.ASCENDING.equals(type)) {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getWoodVolumePerHour))
                    .toList();
        } else {
            searchResult = searchResult.stream()
                    .sorted(Comparator.comparing(WoodworkingMachine::getWoodVolumePerHour).reversed())
                    .toList();
        }
        return searchResult;
    }

}





