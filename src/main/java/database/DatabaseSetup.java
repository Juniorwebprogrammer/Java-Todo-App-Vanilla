package database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTasksTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "description VARCHAR(255) NOT NULL," +
                "completed BOOLEAN DEFAULT FALSE," +
                "user_id INT," +
                "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE" +
                ");";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabla 'tasks' verificada/creada con éxito.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void creteUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(50) NOT NULL UNIQUE," +
                "password VARCHAR(255) NOT NULL" +
                ");";
        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Tabla 'users' lista.");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
