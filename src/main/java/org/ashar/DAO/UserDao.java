package org.ashar.DAO;

import org.ashar.Entity.User;
import org.ashar.Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public User save(User user){
        String query = "INSERT INTO Users (username,password,email,isAdmin) VALUES (?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement statement = con.prepareStatement(query)){
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4,0);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public User get(String email) {
        String query = "SELECT * FROM Users WHERE email = ?";
        User user = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setIsAdmin(resultSet.getInt("isadmin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public List<User> get() {
        String query = "SELECT * FROM Users";
        User user = null;
        List<User> allUsers = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setIsAdmin(resultSet.getInt("isAdmin"));

                    allUsers.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
    public void delete(String email){
        String query = "DELETE FROM Users WHERE email = ?";
        try(Connection con = DBConnection.getConnection();
        PreparedStatement statement = con.prepareStatement(query)){
            statement.setString(1,email);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User findByUsername(String username){
        String query = "SELECT * FROM Users WHERE username = ?";
        User user = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                    user.setCreatedAt(resultSet.getTimestamp("created_at"));
                    user.setIsAdmin(resultSet.getInt("isAdmin"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
