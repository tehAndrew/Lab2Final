package com.group14.App.Model;

import com.group14.App.Observer.CarMessage;
import com.group14.App.Observer.Observable;
import com.group14.Vehicles.Saab95;
import com.group14.Vehicles.Scania;
import com.group14.Vehicles.Vehicle;
import com.group14.Vehicles.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarModel extends Observable {
    private static final int DELAY = 50;

    private final Timer timer;
    private final List<Vehicle> cars;
    private int screenWidth;
    private int imageWidth;

    public CarModel(int screenWidth, int imageWidth){
        this.screenWidth = screenWidth;
        this.imageWidth = imageWidth;

        cars = new ArrayList<>();
        cars.add(new Volvo240(0,0));
        cars.add(new Saab95(0,100));
        cars.add(new Scania(0,200));
        cars.add(new Scania(0,300));

        timer = new Timer(DELAY, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<CarMessage> cMessages = new ArrayList<>();
            for (Vehicle car : cars) {
                car.move();
                cMessages.add(createCarMessage(car));

                if (car.getX() + imageWidth > screenWidth || car.getX() < 0) {
                    car.turnLeft(Math.PI);
                }
            }
            notifyObservers(cMessages);
        }
    }

    private CarMessage createCarMessage(Vehicle vehicle){
        return new CarMessage(vehicle.getModelName(),
                              (int) vehicle.getX(),
                              (int) vehicle.getY(),
                               vehicle.getCurrentSpeed());
    }

    public void gas(int amount){
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    public void raiseRamp() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                Scania scania = (Scania) car;
                scania.raiseFlatbed(70);
            }
        }
    }

    public void lowerRamp() {
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                Scania scania = (Scania) car;
                scania.lowerFlatbed(70);
            }
        }
    }

    public void start() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    public void stop() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }
}
