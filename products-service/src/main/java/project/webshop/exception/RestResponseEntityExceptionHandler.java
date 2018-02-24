package project.webshop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ExceptionResponse>
    todoNotFound(EntityNotFoundException ex) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(  ex.getMessage(),
                        "Any details you would want to add");
        return new ResponseEntity<ExceptionResponse>
                (exceptionResponse, new HttpHeaders(),
                        HttpStatus.NOT_FOUND);
    }
}