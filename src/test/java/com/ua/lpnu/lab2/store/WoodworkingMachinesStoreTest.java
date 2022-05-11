package com.ua.lpnu.lab2.store;

import com.ua.lpnu.lab2.enums.TypeOfSort;
import com.ua.lpnu.lab2.enums.TypeOfWork;
import com.ua.lpnu.lab2.machines.CircularMachine;
import com.ua.lpnu.lab2.machines.MillingMachine;
import com.ua.lpnu.lab2.machines.ReymusMachine;
import com.ua.lpnu.lab2.machines.WoodworkingMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WoodworkingMachinesStoreTest {

    private List<WoodworkingMachine> testingList;
    private WoodworkingMachinesStore store;


    @BeforeEach
    void setUp() {
        testingList = new ArrayList<>();
        WoodworkingMachine machine1 = new ReymusMachine(450, 85, 2000, "Jet", 6);
        WoodworkingMachine machine2 = new MillingMachine(200, 45, 500, "Prom SF", "mechanical");
        WoodworkingMachine machine3 = new MillingMachine(250, 25, 400, "Prom SF", "computing");
        WoodworkingMachine machine4 = new CircularMachine(350, 15, 600, "Prom SF", 7);
        testingList = Arrays.asList(machine1, machine2, machine3, machine4);
        store = new WoodworkingMachinesStore();
        store.addMachineToStore(machine1);
        store.addMachineToStore(machine2);
        store.addMachineToStore(machine3);
        store.addMachineToStore(machine4);
    }

    @Test
    void addMachineToStoreTest() throws Exception {
        WoodworkingMachine machine5 = new MillingMachine(100, 50, 800, "Jet", "auto");
        store.addMachineToStore(machine5);

        List<WoodworkingMachine> expectedList = Arrays.asList(testingList.get(0), testingList.get(1),
                testingList.get(2), testingList.get(3), machine5);

        Assertions.assertEquals(expectedList, store.getStoreMachines());

    }

    @Test
    void findMachineByBrandAndTypeTest() throws Exception {

        List<WoodworkingMachine> searchResult;
        searchResult = store.findMachineByBrandAndType(TypeOfWork.MILLING, "Prom SF");
        Assertions.assertFalse(searchResult.isEmpty());
        searchResult.forEach(machine -> {
            Assertions.assertEquals(TypeOfWork.MILLING, machine.getTypeOfWork());
            Assertions.assertEquals("Prom SF", machine.getManufacturerName());
        });

    }

    @Test
    void sortByPowerTest() throws Exception {

        List<WoodworkingMachine> expectedListD;
        List<WoodworkingMachine> expectedListA;
        expectedListD = Arrays.asList(testingList.get(2), testingList.get(1));
        expectedListA = Arrays.asList(testingList.get(1), testingList.get(2));

        testingList = store.findMachineByBrandAndType(TypeOfWork.MILLING, "Prom SF");

        testingList = store.sortByPower(TypeOfSort.DESCENDING);
        Assertions.assertEquals(expectedListD, testingList);

        testingList = store.sortByPower(TypeOfSort.ASCENDING);
        Assertions.assertEquals(expectedListA, testingList);

    }

    @Test
    void sortByVolumePerHourTest() throws Exception {

        List<WoodworkingMachine> expectedListD;
        List<WoodworkingMachine> expectedListA;
        expectedListD = Arrays.asList(testingList.get(1), testingList.get(2));
        expectedListA = Arrays.asList(testingList.get(2), testingList.get(1));

        testingList = store.findMachineByBrandAndType(TypeOfWork.MILLING, "Prom SF");

        testingList = store.sortByVolumePerHour(TypeOfSort.DESCENDING);
        Assertions.assertEquals(expectedListD, testingList);

        testingList = store.sortByVolumePerHour(TypeOfSort.ASCENDING);
        Assertions.assertEquals(expectedListA, testingList);

    }


}