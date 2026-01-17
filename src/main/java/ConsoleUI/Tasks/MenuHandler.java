package ConsoleUI.Tasks;

import Service.Auth.AuthService;
import database.repository.Tasks.TaskRepository;
import database.repository.User.UserRepository;
import model.Tasks.Task;

import java.util.Scanner;

public class MenuHandler {
    private final TaskRepository taskRepository;
    private final Scanner scanner;
    private final AuthService authService = new AuthService();
    private final UserRepository userRepository = new UserRepository();
    private String currentUserToken = null;
    private int loggedUserId = 0;

    public MenuHandler(int loggedUserId) {
        this.taskRepository = new TaskRepository();
        this.scanner = new Scanner(System.in);
        this.loggedUserId = loggedUserId;
    }

    public void start() {
        int option;
        do {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Listar tareas");
            System.out.println("2. Nueva tarea");
            System.out.println("3. Completar tarea (ID)");
            System.out.println("4. Eliminar tarea (ID)");
            System.out.println("0. Salir");
            System.out.print("Selecciona: ");

            option = scanner.nextInt();
            scanner.nextLine();
            handleOption(option, loggedUserId);
        } while (option != 0);
    }

    private void handleOption(int option, int loggedUserId) {
        switch (option) {
            case 1 -> taskRepository.findAll(loggedUserId).forEach(System.out::println);
            case 2 -> {
                System.out.println("Para crear una tarea por favor ingrese una descripción a continución o escriba cancelar para salir de la opción.");
                System.out.print("Description: ");
                String optionValue = scanner.nextLine();
                if (!optionValue.equalsIgnoreCase("cancelar")) {
                    taskRepository.save(new Task(optionValue, this.loggedUserId));
                }
            }

            case 3 -> {
                System.out.println("Para marcar como completada una tarea debe ingresar el ID de la misma a continuación");
                System.out.print("ID de la tarea: ");
                int optionValue = scanner.nextInt();
                if (optionValue != 0) {
                    taskRepository.complete(optionValue);
                }
            }
            case 4 -> {
                System.out.println("Para poder eliminar una tarea debe ingresar el ID de la misma a continuación");
                System.out.print("ID de la tarea: ");
                int optionValue = scanner.nextInt();
                if (optionValue != 0) {
                    taskRepository.delete(optionValue);
                }
            }
        }
    }
}
