package bo.com.ahosfot.patterns.creation.abstractFactory.buttons;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOS Button");
    }
}
