package com.ua.lpnu.lab2;

import com.ua.lpnu.lab2.machines.*;

public class Main {
    public static void main(String[] args) {

        WoodworkingMachine machine1 = new ReymusMachine(130, 50.4, 400, "Holzmann", 6);
        System.out.println(machine1);
        WoodworkingMachine machine2 = new CircularMachine(200, 80.4, 500, "Jet", 90);
        System.out.println(machine2);
        WoodworkingMachine machine3 = new MillingMachine(100, 50, 89.9, "Proma SF", "mechanical");
        System.out.println(machine3);


    }
}
