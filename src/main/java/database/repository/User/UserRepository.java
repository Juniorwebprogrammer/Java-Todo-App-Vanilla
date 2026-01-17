package database.repository.User;

import database.DatabaseConnection;
import model.User.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    public void register(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();

            System.out.println(("Ususario " + user.getUsername() + " registrado correctamente"));
        } catch (SQLException sqlException) {
            System.err.println("Error al registrar un usuario: " + sqlException.getMessage());
        }
    }
}
