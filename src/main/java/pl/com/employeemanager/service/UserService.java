package pl.com.employeemanager.service;

import pl.com.employeemanager.model.User;

public interface UserService {
    User getUserByLogin(String login);
}
