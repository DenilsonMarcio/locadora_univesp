package br.com.moppahtech.locadora.advice;

import br.com.moppahtech.locadora.exceptions.BusinessException;
import br.com.moppahtech.locadora.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
    public static final String MESSAGE = "message";
    public static final String STATUSCODE = "status_code";
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> tratarNotFoundException(final NotFoundException exception){
        Map<String, String> body = new HashMap<>();
        body.put(MESSAGE, exception.getMessage());
        body.put(STATUSCODE, "404");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<Object> tratarNotFoundException(final BusinessException exception){
        Map<String, String> body = new HashMap<>();
        body.put(MESSAGE, exception.getMessage());
        body.put(STATUSCODE, "424");
        return new ResponseEntity<>(body, HttpStatus.FAILED_DEPENDENCY);
    }
}
