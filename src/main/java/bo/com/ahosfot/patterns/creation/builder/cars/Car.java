package bo.com.ahosfot.patterns.creation.builder.cars;

import bo.com.ahosfot.patterns.creation.builder.components.Engine;
import bo.com.ahosfot.patterns.creation.builder.components.GPSNavigator;
import bo.com.ahosfot.patterns.creation.builder.components.Transmission;
import bo.com.ahosfot.patterns.creation.builder.components.TripComputer;
import lombok.Getter;
import lombok.Setter;

public class Car {
    @Getter
    private final CarType carType;
    @Getter
    private final int seats;
    @Getter
    private final Engine engine;
    @Getter
    private final Transmission transmission;
    @Getter
    private final TripComputer tripComputer;
    @Getter
    private final GPSNavigator gpsNavigator;
    @Getter @Setter
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }
}
