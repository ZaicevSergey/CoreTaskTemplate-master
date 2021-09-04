package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Util con = new Util();


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws ClassNotFoundException {
        Connection connection = con.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS User " +
                    "(id BIGINT NOT NULL AUTO_INCREMENT primary key, " +
                    " name VARCHAR(50) NOT NULL, " +
                    " lastName VARCHAR(50) NOT NULL, " +
                    " age TINYINT NOT NULL)");
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void dropUsersTable() throws ClassNotFoundException {
        Connection connection = con.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS User");
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException {
        Connection connection = con.getConnection();
        PreparedStatement pstmt = null;
        try {
            connection.setAutoCommit(false);
            User user = new User(name, lastName, age);
            pstmt = connection.prepareStatement
                    ("INSERT INTO User (name, lastName, age) VALUES (?, ?, ?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getLastName());
            pstmt.setByte(3, user.getAge());
            pstmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQLException");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) throws ClassNotFoundException {
        Connection connection = con.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("DELETE FROM User WHERE id = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<User> getAllUsers() throws ClassNotFoundException {
        Connection connection = con.getConnection();
        Statement statement = null;
        List<User> list = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }

    public void cleanUsersTable() throws ClassNotFoundException {
        Connection connection = con.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement("TRUNCATE TABLE User");
            pstmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                connection.close();
                pstmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}