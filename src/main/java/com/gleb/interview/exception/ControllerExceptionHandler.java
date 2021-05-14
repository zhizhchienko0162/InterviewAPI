package com.gleb.interview.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(NotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String loginHandler(LoginException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(LogoutException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String logoutHandler(LogoutException e) {
        return e.getMessage();
    }

    @SuppressWarnings("SameReturnValue")
    @ResponseBody
    @ExceptionHandler(PropertyValueException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String propertyValueHandler(PropertyValueException e) {
        return "Invalid data";
    }
}