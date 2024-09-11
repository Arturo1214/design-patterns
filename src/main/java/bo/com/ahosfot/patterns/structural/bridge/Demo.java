package bo.com.ahosfot.patterns.structural.bridge;

import bo.com.ahosfot.patterns.structural.bridge.devices.Device;
import bo.com.ahosfot.patterns.structural.bridge.devices.Radio;
import bo.com.ahosfot.patterns.structural.bridge.devices.Tv;
import bo.com.ahosfot.patterns.structural.bridge.remotes.AdvancedRemote;
import bo.com.ahosfot.patterns.structural.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
