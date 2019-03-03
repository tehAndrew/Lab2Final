package com.group14.App.Observer;

public class CarMessage {
        private final String imageKey;
        private final int carX;
        private final int carY;
        private final double carSpeed;

        public CarMessage(String imageKey, int carX, int carY, double carSpeed) {
            this.imageKey = imageKey;
            this.carX     = carX;
            this.carY     = carY;
            this.carSpeed = carSpeed;
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

        public double getCarSpeed() { return carSpeed; }
}
