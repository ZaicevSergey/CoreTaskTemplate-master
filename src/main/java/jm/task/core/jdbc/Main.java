package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Sergey", "Zaicev", (byte) 36);
        userService.saveUser("Andrey", "Medvejenko", (byte) 39);
        userService.saveUser("Viktoriya", "Harlanova", (byte) 30);
        userService.saveUser("Mariya", "Prohovskaya", (byte) 69);

        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
