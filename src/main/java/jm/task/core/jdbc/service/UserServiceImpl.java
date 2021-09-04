package jm.task.core.jdbc.service;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public UserServiceImpl()  {
    }

    public void createUsersTable() throws ClassNotFoundException {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() throws ClassNotFoundException {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException {
        userDaoJDBC.saveUser(name, lastName, age);
        System.out.println("User с именем – "+name+" добавлен в базу данных");
    }

    public void removeUserById(long id) throws ClassNotFoundException {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() throws ClassNotFoundException {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() throws ClassNotFoundException {
        userDaoJDBC.cleanUsersTable();
    }

}