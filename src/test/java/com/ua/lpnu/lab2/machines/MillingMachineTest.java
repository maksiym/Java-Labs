package com.ua.lpnu.lab2.machines;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MillingMachineTest {

    @Test
    void testToString() {
        WoodworkingMachine machine = new MillingMachine(75, 200, 1000, "Holzmann", "mechanical");

        String expected = "Manufacturer name - Holzmann, VPM - 200,0, power - 75, " +
                "price - 1000,0, type of work - MILLING, type of control - mechanical";
        Assertions.assertEquals(expected, machine.toString());
    }
}