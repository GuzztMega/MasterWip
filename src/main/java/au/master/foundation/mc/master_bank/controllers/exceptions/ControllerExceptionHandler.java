package au.master.foundation.mc.master_bank.controllers.exceptions;

import au.master.foundation.mc.master_bank.services.exceptions.NotEnoughFundsException;
import au.master.foundation.mc.master_bank.services.exceptions.ObjectNotFoundException;
import au.master.foundation.mc.master_bank.services.exceptions.SameAccountsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Object Not Found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(SameAccountsException.class)
    public ResponseEntity<StandardError> sameAccounts(SameAccountsException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_GATEWAY.value(),
                "Transfer Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(err);
    }

    @ExceptionHandler(NotEnoughFundsException.class)
    public ResponseEntity<StandardError> notEnoughFunds(NotEnoughFundsException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_GATEWAY.value(),
                "Transfer Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(err);
    }
}
