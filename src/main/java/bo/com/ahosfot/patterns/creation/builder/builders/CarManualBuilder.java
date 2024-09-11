package bo.com.ahosfot.patterns.creation.builder.builders;

import bo.com.ahosfot.patterns.creation.builder.cars.CarType;
import bo.com.ahosfot.patterns.creation.builder.cars.Manual;
import bo.com.ahosfot.patterns.creation.builder.components.Engine;
import bo.com.ahosfot.patterns.creation.builder.components.GPSNavigator;
import bo.com.ahosfot.patterns.creation.builder.components.Transmission;
import bo.com.ahosfot.patterns.creation.builder.components.TripComputer;

public class CarManualBuilder implements Builder {
    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
