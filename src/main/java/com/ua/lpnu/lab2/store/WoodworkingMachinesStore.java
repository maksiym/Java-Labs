package com.ua.lpnu.lab2.store;

import com.ua.lpnu.lab2.enums.TypeOfSort;
import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.WoodworkingMachine;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Getter;


@Getter
public class WoodworkingMachinesStore {

    private List<WoodworkingMachine> storeMachines = new ArrayList<>();
    private List<WoodworkingMachine> searchResult = new ArrayList<>();

    public void addMachineToStore(WoodworkingMachine machine) {
        storeMachines.add(machine);
    }

    public List<WoodworkingMachine> findMachineByBrandAndType(TypeOfWork type,
                                                              String manufacturerName) {
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
                    .sorted(Comparator.comparing(WoodworkingMachine::getWoodVolumePerHour)
                            .reversed())
                    .toList();
        }
        return searchResult;
    }

}