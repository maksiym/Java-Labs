package com.ua.lpnu.lab2.writer;

import com.ua.lpnu.lab2.store.WoodworkingMachinesStore;
import com.ua.lpnu.lab2.machines.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MachineWriterTest {

    private List<WoodworkingMachine> testingList;
    private WoodworkingMachinesStore store;

    @Test
    void writeToFile() {
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

        MachineWriter machineWriter = new MachineWriter();
        machineWriter.writeToFile("result1", store.getStoreMachines());

        Path expectedPath = Paths.get("src\\test\\java\\resources\\expected1.csv");
        Path resultReader = Paths.get("result1.csv");

        List<String> expectedLines = new ArrayList<>();
        List<String> resultLines = new ArrayList<>();

        try {
            expectedLines = Files.readAllLines(expectedPath);
            resultLines = Files.readAllLines(resultReader);
        }catch(IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedLines, resultLines);
    }

    @Test
    void testWriteToFileThatGetsEmptyList() {
        MachineWriter machineWriter = new MachineWriter();
        WoodworkingMachinesStore store = new WoodworkingMachinesStore();
        machineWriter.writeToFile("result2", store.getStoreMachines());

        Path expectedPath = Paths.get("src\\test\\java\\resources\\expected2.csv");
        Path resultReader = Paths.get("result2.csv");

        List<String> expectedLines = new ArrayList<>();
        List<String> resultLines = new ArrayList<>();

        try {
            expectedLines = Files.readAllLines(expectedPath);
            resultLines = Files.readAllLines(resultReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedLines, resultLines);
        assertTrue(expectedLines.size() == 0 && resultLines.size() == 0);

    }

    @Test
    void testWriteToFileThatGetsListOfMillingMachines() {
        testingList = new ArrayList<>();

        WoodworkingMachine machine1 = new MillingMachine(200, 45, 500, "Prom SF", "mechanical");
        WoodworkingMachine machine2 = new MillingMachine(250, 25, 400, "Prom SF", "computing");
        testingList = Arrays.asList(machine1, machine2);
        store = new WoodworkingMachinesStore();
        store.addMachineToStore(machine1);
        store.addMachineToStore(machine2);

        MachineWriter machineWriter = new MachineWriter();
        machineWriter.writeToFile("result3", store.getStoreMachines());

        Path expectedPath = Paths.get("src\\test\\java\\resources\\expected3.csv");
        Path resultReader = Paths.get("result3.csv");

        List<String> expectedLines = new ArrayList<>();
        List<String> resultLines = new ArrayList<>();
        try {
            expectedLines = Files.readAllLines(expectedPath);
            resultLines = Files.readAllLines(resultReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(expectedLines, resultLines);

    }

}

