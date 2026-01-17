package ConsoleUI.Auth;

import Service.Auth.AuthService;
import database.repository.User.UserRepository;
import model.User.User;

import java.io.Console;
import java.util.Scanner;

public class AuthUi {
    private final AuthService authService = new AuthService();
    private final UserRepository userRepository = new UserRepository();
    private final Scanner scanner = new Scanner(System.in);

    public String showAuthMenu() {
        while (true) {
            System.out.println("\n--- ACCESO AL SISTEMA ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                String token = handleLogin();
                if (token != null) return token;
            } else if (option == 2) {
                handleRegister();
            } else if (option == 0) {
                System.exit(0);
            }
        }
    }

    private String handleLogin() {
        System.out.print("Usuario: ");
        String user = scanner.nextLine();

        String pass = readPasswordSafe("Contraseña: ");

        String token = authService.authenticate(user, pass);
        if (token != null) {
            System.out.println("✅ Login exitoso.");
            return token;
        }
        System.out.println("❌ Credenciales incorrectas.");
        return null;
    }

    private void handleRegister() {
        System.out.print("Nuevo Usuario: ");
        String user = scanner.nextLine();

        String pass = readPasswordSafe("Nueva Contraseña: ");

        userRepository.register(new User(user, pass));
        System.out.println("✅ Usuario registrado con éxito.");
    }

    private String readPasswordSafe(String prompt) {
        Console console = System.console();

        if (console != null) {
            char[] passwordChars = console.readPassword(prompt);
            return new String(passwordChars);
        } else {
            System.out.print(prompt + "(Eco activado en IDE): ");
            return scanner.nextLine();
        }
    }
}
