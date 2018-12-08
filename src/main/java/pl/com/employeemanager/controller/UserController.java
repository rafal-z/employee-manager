package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pl.com.employeemanager.model.Authority;
import pl.com.employeemanager.model.User;
import pl.com.employeemanager.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody
    Object saveUser(@RequestBody Object user) {
        return null;
    }
}

 
