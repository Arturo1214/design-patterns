package bo.com.ahosfot.patterns.creation.abstractFactory.factories;

import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.Button;
import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.MacOSButton;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.CheckBox;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.MacOSCheckBox;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
