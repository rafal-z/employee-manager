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
            return sendError(res, HttpStatus.CONFLICT.value(), "PASSWORD_NOT_MEETS_REQUIREMENTS", ex);
        } else if(ex instanceof InvalidOldPasswordException){
            return sendError(res, HttpStatus.CONFLICT.value(), "INVALID_OLD_PASSWORD", ex);
        } else if(ex instanceof PasswordsCanNotBeEqualException){
            return sendError(res, HttpStatus.CONFLICT.value(), "PASSWORDS_CAN_NOT_BE_EQUAL", ex);
        } else {
            return sendError(res, HttpStatus.INTERNAL_SERVER_ERROR.value(), "INTERNAL_SERVER_ERROR", ex);
        }
    }

    private Error sendError(HttpServletResponse res, Integer status, String reason, Exception ex){
        res.setStatus(status);
        return new Error(reason, ex.getMessage());
    }
}
