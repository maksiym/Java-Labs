package com.ua.lpnu.lab2.machines;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReymusMachineTest {

    @Test
    void testToString() {
        WoodworkingMachine machine = new ReymusMachine(75, 200, 1000, "Holzmann", 5);

        String expected = "Manufacturer name - Holzmann, VPM - 200,0, power - 75, " +
                "price - 1000,0, type of work - REYMUS, number of types - 5";
        Assertions.assertEquals(expected, machine.toString());
    }
}