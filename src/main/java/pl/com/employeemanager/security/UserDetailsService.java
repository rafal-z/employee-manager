package pl.com.employeemanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.com.employeemanager.exception.ExpiredPasswordException;
import pl.com.employeemanager.exception.UserNotActiveException;
import pl.com.employeemanager.model.Authority;
import pl.com.employeemanager.model.User;
import pl.com.employeemanager.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        User user = userService.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User was not found in the database");
        } else if (!user.isActive()) {
            throw new UserNotActiveException("User was not active");
        } else if ( (user.getExpiredPassword() != null) && (new Date().after(user.getExpiredPassword())) ){
            throw new ExpiredPasswordException("Password expired");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Authority authority : user.getAuthorities()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
