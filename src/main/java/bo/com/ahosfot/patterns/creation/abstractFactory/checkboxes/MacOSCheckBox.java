package bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes;

public class MacOSCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have created MacOS Checkbox");
    }
}
