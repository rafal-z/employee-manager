package pl.com.employeemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Error processException(HttpServletRequest req, HttpServletResponse res, Exception ex){
        if(ex instanceof PasswordNotMeetsRequirementsException){
            res.setStatus(HttpStatus.CONFLICT.value());
            return new Error("PASSWORD_NOT_MEETS_REQUIREMENTS", ex.getMessage());
        } else if(ex instanceof InvalidOldPasswordException){
            res.setStatus(HttpStatus.CONFLICT.value());
            return new Error("INVALID_OLD_PASSWORD", ex.getMessage());
        } else if(ex instanceof PasswordsCanNotBeEqualException){
            res.setStatus(HttpStatus.CONFLICT.value());
            return new Error("PASSWORDS_CAN_NOT_BE_EQUAL", ex.getMessage());
        } else {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new Error("INTERNAL_SERVER_ERROR", "");
        }
    }
}
