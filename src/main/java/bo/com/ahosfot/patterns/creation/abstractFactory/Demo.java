package bo.com.ahosfot.patterns.creation.abstractFactory;

import bo.com.ahosfot.patterns.creation.abstractFactory.app.Application;
import bo.com.ahosfot.patterns.creation.abstractFactory.factories.GUIFactory;
import bo.com.ahosfot.patterns.creation.abstractFactory.factories.MacOsFactory;
import bo.com.ahosfot.patterns.creation.abstractFactory.factories.WindowsFactory;

public class Demo {

    public static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            factory = new WindowsFactory();
        } else if (osName.toLowerCase().contains("linux")) {
            factory = new WindowsFactory();
        } else if (osName.toLowerCase().contains("mac")) {
            factory = new MacOsFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
