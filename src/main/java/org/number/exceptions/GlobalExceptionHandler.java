package org.number.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.number.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        return new ResponseEntity<>(new ErrorResponse("Bad Request: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // Gestion des erreurs de type "not found" (erreur 404)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFound(NoHandlerFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse("Not Found: " + ex), HttpStatus.NOT_FOUND);
    }

    // Gestion des erreurs internes du serveur (erreur 500)
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Internal Server Error: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Gestion des erreurs liées à la configuration
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ErrorResponse("Invalid Argument: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
