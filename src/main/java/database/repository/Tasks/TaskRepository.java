package database.repository.Tasks;

import database.DatabaseConnection;
import model.Tasks.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public void save(Task task) {
        String sql = "INSERT INTO tasks (description, completed, user_id) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, task.getDescription());
            statement.setBoolean(2, task.isCompleted());
            statement.setInt(3, task.getUserId());

            statement.executeUpdate();
            System.out.println("Objeto Task guardado en la base de datos");
        } catch (Exception exception) {
            System.err.println("Error al guardar la tarea: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    public List<Task> findAll(int userId) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT id, description, completed FROM tasks WHERE user_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(rs.getInt("id"), rs.getString("description"), rs.getBoolean("completed"), userId));
            }
        } catch (SQLException sqlException) {
            System.out.println("Error al listar: " + sqlException.getMessage());
        }

        return tasks;
    }

    public void complete(int id) {
        String sql = "UPDATE tasks SET completed = true WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Tarea marcada como completada");
        } catch (SQLException sqlException) {
            System.out.println("Error al listar: " + sqlException.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Tarea eliminada");
        } catch (SQLException sqlException) {
            System.out.println("Error al eliminar: " + sqlException.getMessage());
        }
    }
}
