package bo.com.ahosfot.patterns.creation.builder.director;

import bo.com.ahosfot.patterns.creation.builder.builders.Builder;
import bo.com.ahosfot.patterns.creation.builder.cars.CarType;
import bo.com.ahosfot.patterns.creation.builder.components.Engine;
import bo.com.ahosfot.patterns.creation.builder.components.GPSNavigator;
import bo.com.ahosfot.patterns.creation.builder.components.Transmission;
import bo.com.ahosfot.patterns.creation.builder.components.TripComputer;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }

}
