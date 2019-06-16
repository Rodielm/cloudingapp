package es.uv.twcam.cloudingapi.api;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import es.uv.twcam.cloudingapi.services.ErrorDetails;
import es.uv.twcam.cloudingapi.services.MessageNotFoundException;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<?> servletRequestBindingException(MessageNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(e.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        errorDetails.setDevErrorMessage(sw.toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
}