package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.accounts.SystemUserService;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.SystemUser;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/systemuser/")

public class SystemUsersController {
    private SystemUserService systemUserService;

    @Autowired
    public SystemUsersController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PostMapping("loginDtoMail")
    public ResponseEntity<?> loginDtoMail(@Valid @RequestBody UserLoginDto userLoginDto){
        return ResponseEntity.ok(this.systemUserService.login(userLoginDto));
    }

    @PostMapping("registery")
    public ResponseEntity<?> registery(@Valid @RequestBody SystemUser systemUser){
        return ResponseEntity.ok(this.systemUserService.register(systemUser));
    }

    @PostMapping("confirm")
    public ResponseEntity<?> confirm(@Valid @RequestBody int id){
        return ResponseEntity.ok(this.systemUserService.confirmEmployer(id));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
