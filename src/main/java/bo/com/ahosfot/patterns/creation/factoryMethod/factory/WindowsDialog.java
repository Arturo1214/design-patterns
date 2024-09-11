package bo.com.ahosfot.patterns.creation.factoryMethod.factory;

import bo.com.ahosfot.patterns.creation.factoryMethod.buttons.Button;
import bo.com.ahosfot.patterns.creation.factoryMethod.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
