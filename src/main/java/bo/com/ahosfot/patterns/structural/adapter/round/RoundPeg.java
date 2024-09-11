package bo.com.ahosfot.patterns.structural.adapter.round;

import lombok.Getter;

public class RoundPeg {

    @Getter
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }
}
