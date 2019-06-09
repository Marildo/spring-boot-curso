package br.com.curso.handler;

import br.com.curso.error.ResourceNotFoundDetails;
import br.com.curso.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception){

        ResourceNotFoundDetails details = new ResourceNotFoundDetails()
                .setLocalDateTime(LocalDateTime.now())
                .setStatus(HttpStatus.NOT_FOUND.value())
                .setTitle("Resource not found 3")
                .setDetail(exception.getMessage())
                .setDeveloperMessage(exception.toString())
                .setPath(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

        return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }
}
