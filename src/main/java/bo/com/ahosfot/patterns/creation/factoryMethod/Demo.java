package bo.com.ahosfot.patterns.creation.factoryMethod;

import bo.com.ahosfot.patterns.creation.factoryMethod.factory.Dialog;
import bo.com.ahosfot.patterns.creation.factoryMethod.factory.HtmlDialog;
import bo.com.ahosfot.patterns.creation.factoryMethod.factory.WindowsDialog;

public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            dialog = new WindowsDialog();
        } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.out.println("Mac os");
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic()  {
        dialog.renderWindow();
    }
}
