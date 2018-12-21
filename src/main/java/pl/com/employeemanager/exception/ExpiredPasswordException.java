package pl.com.employeemanager.exception;

import org.springframework.security.core.AuthenticationException;

public class ExpiredPasswordException extends AuthenticationException {
    public ExpiredPasswordException(String msg, Throwable t) {
        super(msg, t);
    }

    public ExpiredPasswordException(String msg) {
        super(msg);
    }
}
