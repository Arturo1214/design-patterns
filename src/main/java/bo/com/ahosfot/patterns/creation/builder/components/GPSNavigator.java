package bo.com.ahosfot.patterns.creation.builder.components;

import lombok.Getter;

public class GPSNavigator {

    @Getter
    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String route) {
        this.route = route;
    }
}
