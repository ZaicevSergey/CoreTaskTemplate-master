package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.model.User;


import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoHibernateImpl();

    public UserServiceImpl()  {
    }

    public void createUsersTable() throws ClassNotFoundException, SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws ClassNotFoundException, SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws ClassNotFoundException, SQLException {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws ClassNotFoundException, SQLException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws ClassNotFoundException, SQLException {
        userDao.cleanUsersTable();
    }

}