package pl.com.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.com.employeemanager.dao.UserDAO;
import pl.com.employeemanager.dto.UserDTO;
import pl.com.employeemanager.mapper.UserMapper;
import pl.com.employeemanager.model.User;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private final Integer MINIMUM_PASSWORD_LENGTH = 6;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserByLogin(String login) {
        User user = userDAO.getUserByLogin(login);
        return userMapper.repack(user);
    }

    @Override
    public User getUserEntity(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    public boolean validatePassword(User user, String password){
        if(BCrypt.checkpw(password, user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean passwordMeetsMinimumRequirements(String password){
        return passwordIsMinimumLength(password) && passwordContainDigit(password) && passwordContainSpecialCharacter(password);
    }

    private boolean passwordIsMinimumLength(String password){
        return password.length() >= MINIMUM_PASSWORD_LENGTH;
    }

    private boolean passwordContainDigit(String password){
        for(int i=0; i<password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    private boolean passwordContainSpecialCharacter(String password){
        for(int i=0; i<password.length(); i++) {
            if (password.substring(i, i+1).matches("[^A-Za-z0-9 ]")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeUserPassword(User user, String password){
        String pw = BCrypt.hashpw(password, BCrypt.gensalt(11));
        user.setPassword(pw);
        user.setExpiredPassword(extendExpiredPasswordDate());
        userDAO.updateUser(user);
    }

    private Date extendExpiredPasswordDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }
}
