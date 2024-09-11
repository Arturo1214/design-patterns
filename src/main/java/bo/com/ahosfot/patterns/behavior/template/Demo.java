package bo.com.ahosfot.patterns.behavior.template;

import bo.com.ahosfot.patterns.behavior.template.networks.Facebook;
import bo.com.ahosfot.patterns.behavior.template.networks.Network;
import bo.com.ahosfot.patterns.behavior.template.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.println("Input user name: ");
        String username = reader.readLine();
        System.out.println("Input password: ");
        String password = reader.readLine();

        //Enter the message
        System.out.println("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(username, password);
        } else if (choice == 2) {
            network = new Twitter(username, password);
        }
        network.post(message);
    }
}
