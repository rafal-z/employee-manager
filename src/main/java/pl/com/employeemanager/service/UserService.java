package pl.com.employeemanager.service;

import pl.com.employeemanager.dto.UserDTO;
import pl.com.employeemanager.model.User;

public interface UserService {
    UserDTO getUserByLogin(String login);
    User getUserEntity(String login);
    boolean validatePassword(User user, String password);
    boolean passwordMeetsMinimumRequirements(String password);
    void changeUserPassword(User user, String oldPassword);
}
