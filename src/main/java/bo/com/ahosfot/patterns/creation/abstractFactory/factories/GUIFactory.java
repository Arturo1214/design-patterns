package bo.com.ahosfot.patterns.creation.abstractFactory.factories;

import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.Button;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
