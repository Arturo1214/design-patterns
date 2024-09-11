package bo.com.ahosfot.patterns.creation.abstractFactory.app;

import bo.com.ahosfot.patterns.creation.abstractFactory.buttons.Button;
import bo.com.ahosfot.patterns.creation.abstractFactory.checkboxes.CheckBox;
import bo.com.ahosfot.patterns.creation.abstractFactory.factories.GUIFactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }

}
