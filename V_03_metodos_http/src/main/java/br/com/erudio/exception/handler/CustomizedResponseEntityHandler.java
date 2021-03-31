package br.com.erudio.exception.handler;

import br.com.erudio.exception.ExceptionReponse;
import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionReponse> handleAllExceptions(Exception e, WebRequest request){
        ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), e.getMessage(), request.getDescription(false));
       return new ResponseEntity<>(exceptionReponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionReponse> handleBadRequestExceptions(Exception e, WebRequest request){
        ExceptionReponse exceptionReponse = new ExceptionReponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionReponse, HttpStatus.BAD_REQUEST);
    }
}
