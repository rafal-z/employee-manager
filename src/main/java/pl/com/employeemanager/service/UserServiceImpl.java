package pl.com.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.employeemanager.dao.UserDAO;
import pl.com.employeemanager.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }
}
