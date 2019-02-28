package com.group14.App;

import com.group14.App.Controller.CarController;
import com.group14.App.Model.CarModel;
import com.group14.App.View.CarView;
import com.group14.ResourceLoader.ImageLoader;

public class CarApp {
    private final int SCREENWIDTH = 800;
    private final int SCREENHEIGHT = 800;

    private CarModel model;
    private CarView view;
    private CarController controller;
    private ImageLoader imageLoader;

    private CarApp(){
        imageLoader = new ImageLoader();
        // All images have the same width.
        imageLoader.loadFromFile("Saab95.jpg", "Saab95");
        imageLoader.loadFromFile("Scania.jpg", "Scania");
        imageLoader.loadFromFile("Volvo240.jpg", "Volvo240");

        model = new CarModel(SCREENWIDTH, imageLoader.getImage("Saab95").getWidth());
        view = new CarView("Seifs bil-race 2: Simon gasar som en kung!", SCREENWIDTH, SCREENHEIGHT );
        controller = new CarController(model, view);

        model.addObserver(view);

        view.setImageLoader(imageLoader);
    }

    public static void main(String[] args){
        new CarApp();
    }
}
