package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;



import java.sql.SQLException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Sergey", "Zaicev", (byte)36);
        userService.saveUser("Andrey", "Medvejenko", (byte)39);
        userService.saveUser("Viktoriya", "Harlanova", (byte)30);
        userService.saveUser("Mariya", "Prohovskaya", (byte)69);

        List<User> allUsers= userService.getAllUsers();
        for (User i:allUsers) {
            System.out.println(i);
        }
       userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
