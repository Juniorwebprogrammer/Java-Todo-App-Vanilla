import ConsoleUI.Auth.AuthUi;
import ConsoleUI.Tasks.MenuHandler;
import Service.Auth.JwtUtil;
import database.DatabaseSetup;

public class Main {
    public static void main(String[] args) {
        String jwtToken;
        DatabaseSetup.createTasksTable();
        DatabaseSetup.creteUserTable();
        AuthUi authUi = new AuthUi();

        jwtToken = authUi.showAuthMenu();

        if (jwtToken != null) {
            int loggedUserId = JwtUtil.getUserIdFromToken(jwtToken);
            System.out.println("Tu Token JWT es: " + jwtToken);
            MenuHandler menuHandlerUI = new MenuHandler(loggedUserId);
            menuHandlerUI.start();
        }
    }
}
