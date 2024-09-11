package bo.com.ahosfot.patterns.structural.adapter.square;

import lombok.Getter;

public class SquarePeg {

    @Getter
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getSquare() {
        return Math.pow(width, 2);
    }
}
