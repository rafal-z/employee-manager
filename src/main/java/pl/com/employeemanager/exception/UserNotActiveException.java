package pl.com.employeemanager.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotActiveException extends AuthenticationException {
    public UserNotActiveException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActiveException(String msg) {
        super(msg);
    }
}
