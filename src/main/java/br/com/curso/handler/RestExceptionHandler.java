package br.com.curso.handler;

import br.com.curso.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception) {

        ResourceNotFoundDetails details = new ResourceNotFoundDetails();
        details.setStatus(HttpStatus.NOT_FOUND.value())
                .setTitle("Resource not found 3")
                .setDetail(exception.getMessage())
                .setDeveloperMessage(exception.toString())
                .setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        ValidationErrorDetails details = new ValidationErrorDetails();
        details.setStatus(HttpStatus.BAD_REQUEST.value())
                .setTitle("Field Validation Error")
                .setDetail(exception.getMessage())
                .setDeveloperMessage(exception.toString())
                .setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.stream().forEach(fieldError -> details.addError(fieldError.getField(),
                fieldError.getDefaultMessage()));

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<?> invalidJwtAutenticationException(Exception exception , WebRequest request) {

        NotAuthenticationDetails notAuth = new NotAuthenticationDetails();
        notAuth.setStatus(HttpStatus.BAD_REQUEST.value())
                .setTitle("Not Authentication")
                .setDetail(exception.getMessage())
                .setDeveloperMessage(exception.toString())
                .setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

        return new ResponseEntity<>(notAuth, HttpStatus.BAD_REQUEST);
    }
}
