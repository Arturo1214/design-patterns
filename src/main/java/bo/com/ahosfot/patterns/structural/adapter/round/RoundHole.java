package bo.com.ahosfot.patterns.structural.adapter.round;

import lombok.Getter;

public class RoundHole {

    @Getter
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return this.radius >= roundPeg.getRadius();
    }
}
