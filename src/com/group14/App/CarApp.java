package com.group14.App;

import com.group14.App.Controller.CarController;
import com.group14.App.Model.CarModel;
import com.group14.App.View.CarView;
import com.group14.App.View.SpeedView;
import com.group14.ResourceLoader.ImageLoader;

public class CarApp {
    private final int CAR_VIEW_WIDTH = 800;
    private final int CAR_VIEW_HEIGHT = 800;
    private final int SPEED_VIEW_WIDTH = 280;

    private CarModel model;
    private CarView mainView;
    private SpeedView speedView;
    private CarController controller;
    private ImageLoader imageLoader;

    private CarApp(){
        imageLoader = new ImageLoader();
        imageLoader.loadFromFile("Saab95.jpg", "Saab95");
        imageLoader.loadFromFile("Scania.jpg", "Scania");
        imageLoader.loadFromFile("Volvo240.jpg", "Volvo240");

        model = new CarModel(CAR_VIEW_WIDTH, imageLoader.getImage("Saab95").getWidth());
        mainView = new CarView("Car Sim", CAR_VIEW_WIDTH, CAR_VIEW_HEIGHT);
        speedView = new SpeedView("Speed", SPEED_VIEW_WIDTH, 0);
        controller = new CarController(model, mainView);

        model.addObserver(mainView);
        model.addObserver(speedView);

        mainView.setImageLoader(imageLoader);
    }

    public static void main(String[] args){
        new CarApp();
    }
}
