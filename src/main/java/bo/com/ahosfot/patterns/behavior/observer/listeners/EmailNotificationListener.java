package bo.com.ahosfot.patterns.behavior.observer.listeners;

import java.io.File;

public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " +
                eventType + " operation wtih the following file: " + file.getName());
    }
}
