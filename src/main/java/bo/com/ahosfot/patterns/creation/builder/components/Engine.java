package bo.com.ahosfot.patterns.creation.builder.components;

import lombok.Getter;

public class Engine {
    @Getter
    private final double volume;
    @Getter
    private double mileage;
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(double mileage) {
        if (started) {
            mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }
}
