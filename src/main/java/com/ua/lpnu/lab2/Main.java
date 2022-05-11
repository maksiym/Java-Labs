package com.ua.lpnu.lab2;

import com.ua.lpnu.lab2.enums.TypeOfSort;
import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.*;
import com.ua.lpnu.lab2.store.WoodworkingMachinesStore;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        WoodworkingMachine machine1 = new ReymusMachine(500, 100, 4500, "Holzmann", 6);
        WoodworkingMachine machine2 = new ReymusMachine(650, 115, 5000, "Holzmann", 6);
        WoodworkingMachine machine3 = new ReymusMachine(450, 85, 2000, "Jet", 6);
        WoodworkingMachine machine4 = new MillingMachine(200, 25, 500, "Prom SF", "mechanical");
        WoodworkingMachine machine5 = new MillingMachine(250, 45, 400, "Prom SF", "computing");
        WoodworkingMachine machine6 = new MillingMachine(100, 50, 800, "Jet", "auto");
        WoodworkingMachine machine7 = new CircularMachine(400, 20, 750, "Jet", 5);
        WoodworkingMachine machine8 = new CircularMachine(350, 15, 600, "Prom SF", 7);
        WoodworkingMachine machine9 = new CircularMachine(240, 12, 380, "Holzmann", 4);

        WoodworkingMachinesStore assortment = new WoodworkingMachinesStore();
        assortment.addMachineToStore(machine1);
        assortment.addMachineToStore(machine2);
        assortment.addMachineToStore(machine3);
        assortment.addMachineToStore(machine4);
        assortment.addMachineToStore(machine5);
        assortment.addMachineToStore(machine6);
        assortment.addMachineToStore(machine7);
        assortment.addMachineToStore(machine8);
        assortment.addMachineToStore(machine9);

        List<WoodworkingMachine> store;
        store = assortment.findMachineByBrandAndType(TypeOfWork.MILLING, "Prom SF");
        if (store.isEmpty()) {
            System.out.println("No machines found! :(");
        } else {
            System.out.println("Sorted by ascending power: ");
            store = assortment.sortByPower(TypeOfSort.ASCENDING);
            store.forEach(System.out::println);
            System.out.println("Sorted by descending power: ");
            store = assortment.sortByPower(TypeOfSort.DESCENDING);
            store.forEach(System.out::println);
            System.out.println("Sorted by ascending VPM: ");
            store = assortment.sortByVolumePerHour(TypeOfSort.ASCENDING);
            store.forEach(System.out::println);
            System.out.println("Sorted by descending VPM: ");
            store = assortment.sortByVolumePerHour(TypeOfSort.DESCENDING);
            store.forEach(System.out::println);
        }


    }
}