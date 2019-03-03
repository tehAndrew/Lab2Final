package com.group14.Vehicles;

import java.util.Random;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, double x, double y) {
        Vehicle vehicle = null;
        switch (type) {
            case "Saab95":
                vehicle = new Saab95(x, y);
                break;
            case "Volvo240":
                vehicle = new Volvo240(x, y);
                break;
            case "Scania":
                vehicle = new Scania(x, y);
                break;
            case "random":
                vehicle = randomVehicle(x, y);
        }
        return vehicle;
    }

    private static Vehicle randomVehicle(double x, double y) {
        Random rand = new Random();
        int randInt = rand.nextInt(3);
        Vehicle vehicle = null;

        switch (randInt) {
            case 0:
                vehicle = new Saab95(x, y);
                break;
            case 1:
                vehicle = new Volvo240(x, y);
                break;
            case 2:
                vehicle = new Scania(x, y);
        }
        return vehicle;
    }
}
