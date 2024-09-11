package bo.com.ahosfot.patterns.behavior.state;

import bo.com.ahosfot.patterns.behavior.state.ui.Player;
import bo.com.ahosfot.patterns.behavior.state.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
