package bo.com.ahosfot.patterns.creation.abstractFactory.factories;

import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.Button;
import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.WindowsButton;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.CheckBox;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.WindowsCheckBox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox() ;
    }
}
