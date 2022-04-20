package com.ua.lpnu.lab2.store;

import java.util.ArrayList;
import java.util.List;

import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.*;

public class WoodworkingMachinesStore {

    private List<WoodworkingMachine> store = new ArrayList<>();
    public WoodworkingMachinesStore() {}
    public WoodworkingMachinesStore(List<WoodworkingMachine> store) {
        this.store = store;
    }

    public void addMachineToStore(WoodworkingMachine machine) {
        store.add(machine);
    }
    public WoodworkingMachine findMachineByBrandAndType (TypeOfWork type, String manufacturerName) {
        return null;
    }
    public List<WoodworkingMachine> findByPower () {
        return null;
    }
    public List<WoodworkingMachine> findByVolumePerHour () {
        return null;
    }

}