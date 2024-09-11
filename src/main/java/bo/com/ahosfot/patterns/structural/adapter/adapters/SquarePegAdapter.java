package bo.com.ahosfot.patterns.structural.adapter.adapters;

import bo.com.ahosfot.patterns.structural.adapter.round.RoundPeg;
import bo.com.ahosfot.patterns.structural.adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow((this.squarePeg.getWidth() / 2), 2) * 2);
    }
}
