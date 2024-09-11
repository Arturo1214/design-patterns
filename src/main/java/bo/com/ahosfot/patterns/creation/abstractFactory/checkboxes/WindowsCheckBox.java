package bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("You have created Windows CheckBox");
    }
}
