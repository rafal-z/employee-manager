package pl.com.employeemanager.dao;

import pl.com.employeemanager.model.User;

public interface UserDAO {
    User getUserByLogin(String login);
    Integer updateUser(User user);
}
