package com.ua.lpnu.lab2.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.ua.lpnu.lab2.machines.WoodworkingMachine;


public class MachineWriter {

    public void writeToFile(String fileName, List<WoodworkingMachine> machines) {
        try (FileWriter writer = new FileWriter(fileName + ".csv")) {
            String previousClassName = "";
            for (WoodworkingMachine machine : machines) {
                if (!machine.getClass().getSimpleName().equals(previousClassName)) {
                    writer.write(machine.getHeaders());
                    writer.write("\r\n");
                    previousClassName = machine.getClass().getSimpleName();
                }
                writer.write(machine.toCSV());
                writer.write("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
