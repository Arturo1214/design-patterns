package bo.com.ahosfot.patterns.creation.builder.builders;

import bo.com.ahosfot.patterns.creation.builder.cars.CarType;
import bo.com.ahosfot.patterns.creation.builder.components.Engine;
import bo.com.ahosfot.patterns.creation.builder.components.GPSNavigator;
import bo.com.ahosfot.patterns.creation.builder.components.Transmission;
import bo.com.ahosfot.patterns.creation.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType carType);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
