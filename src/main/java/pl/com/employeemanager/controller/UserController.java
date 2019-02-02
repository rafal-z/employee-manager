package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.com.employeemanager.dto.UserDTO;
import pl.com.employeemanager.exception.PasswordsCanNotBeEqualException;
import pl.com.employeemanager.exception.InvalidOldPasswordException;
import pl.com.employeemanager.exception.PasswordNotMeetsRequirementsException;
import pl.com.employeemanager.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public @ResponseBody
    UserDTO getUser(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    Object saveUser(@RequestBody Object user) {
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO getCurrentUser() {
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if(grantedAuthorities == null) {
            return null;
        }
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority authority : grantedAuthorities) {
            authorities.add(authority.getAuthority());
        }

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(login);
        userDTO.setAuthorities(authorities);
        return userDTO;
    }

    @RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
    public void changePassword(@RequestParam("login") String login,
                               @RequestParam("newPassword") String newPassword,
                               @RequestParam("oldPassword") String oldPassword){
        pl.com.employeemanager.model.User user = userService.getUserEntity(login);
        if (!userService.validatePassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        } else if(userService.validatePassword(user, newPassword)) {
            throw new PasswordsCanNotBeEqualException();
        } else if(!userService.passwordMeetsMinimumRequirements(newPassword)) {
            throw new PasswordNotMeetsRequirementsException();
        }
        userService.changeUserPassword(user, newPassword);
    }
}

 
