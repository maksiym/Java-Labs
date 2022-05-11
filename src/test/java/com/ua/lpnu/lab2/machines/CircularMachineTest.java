package com.ua.lpnu.lab2.machines;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularMachineTest {


    @Test
    void testToString() {
        WoodworkingMachine machine = new CircularMachine(75, 200, 1000, "Holzmann", 75);

        String expected = "Manufacturer name - Holzmann, VPM - 200,0, power - 75, " +
                "price - 1000,0, type of work - CIRCULAR, level of danger - 75";
        Assertions.assertEquals(expected, machine.toString());


    }
}