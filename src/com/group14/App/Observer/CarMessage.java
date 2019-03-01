package com.group14.App.Observer;

public class CarMessage {
        private String imageKey;
        private int carX;
        private int carY;

        public CarMessage(String imageKey, int carX, int carY) {
            this.imageKey = imageKey;
            this.carX = carX;
            this.carY = carY;
        }

        public String getImageKey() {
            return imageKey;
        }

        public int getCarX() {
            return carX;
        }

        public int getCarY() {
            return carY;
        }

}
