package Service.Auth;

import database.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    public String authenticate(String username, String password) {
        String sql = "SELECT id, password FROM users WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedHash = resultSet.getString("password");
                int userId = resultSet.getInt("id");
                if (org.mindrot.jbcrypt.BCrypt.checkpw(password, storedHash)) {
                    return JwtUtil.generateToken(username, userId);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }
}
