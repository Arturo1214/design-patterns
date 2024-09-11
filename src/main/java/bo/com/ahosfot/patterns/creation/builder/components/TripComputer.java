package bo.com.ahosfot.patterns.creation.builder.components;

import bo.com.ahosfot.patterns.creation.builder.cars.Car;
import lombok.Setter;

public class TripComputer {

    @Setter
    private Car car;

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}
