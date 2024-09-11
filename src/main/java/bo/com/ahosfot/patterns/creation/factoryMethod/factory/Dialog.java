package bo.com.ahosfot.patterns.creation.factoryMethod.factory;

import bo.com.ahosfot.patterns.creation.factoryMethod.buttons.Button;

public abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
