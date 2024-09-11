package bo.com.ahosfot.patterns.behavior.chainOfResponsibility;

import bo.com.ahosfot.patterns.behavior.chainOfResponsibility.middleware.Middleware;
import bo.com.ahosfot.patterns.behavior.chainOfResponsibility.middleware.RoleCheckMiddleware;
import bo.com.ahosfot.patterns.behavior.chainOfResponsibility.middleware.ThrottlingMiddleware;
import bo.com.ahosfot.patterns.behavior.chainOfResponsibility.middleware.UserExistsMiddleware;
import bo.com.ahosfot.patterns.behavior.chainOfResponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void main(String[] args) {
        init();

        boolean success;
        try {
            do {
                System.out.print("Enter email: ");
                String email = null;
                email = reader.readLine();
                System.out.print("Input password: ");
                String password = reader.readLine();
                success = server.logIn(email, password);
            } while (!success);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }
}
