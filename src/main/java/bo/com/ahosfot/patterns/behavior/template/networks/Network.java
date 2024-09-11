package bo.com.ahosfot.patterns.behavior.template.networks;

import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public abstract class Network {
    String username;
    String password;

    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        if (login(username, password)) {
            boolean result = sendData(message.getBytes(StandardCharsets.UTF_8));
            logout();
            return result;
        }
        return false;
    }

    abstract boolean login(String username, String password);
    abstract boolean sendData(byte[] data);
    abstract void logout();

}
