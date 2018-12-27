package pl.com.employeemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<String> getRoles(HttpSession session) {
        SecurityContext context = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) context.getAuthentication().getAuthorities();
        if(grantedAuthorities == null) {
            return null;
        }
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority authority : grantedAuthorities) {
            authorities.add(authority.getAuthority());
        }
        return authorities;
    }
}

 
