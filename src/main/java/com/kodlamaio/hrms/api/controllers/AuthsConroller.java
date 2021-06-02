package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.accounts.AuthService;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

import com.kodlamaio.hrms.entities.dtos.UserLoginDto;
import com.kodlamaio.hrms.entities.dtos.VerifyCodeUserDto;
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
@RequestMapping("/api/auth/")
public class AuthsConroller {
    private AuthService authService;

    @Autowired
    public AuthsConroller(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("registery")
    public ResponseEntity<?> registery(@Valid @RequestBody User user){

        return ResponseEntity.ok(this.authService.registery(user));
    }

    @PostMapping("registeryJobSeeker")
    public ResponseEntity<?> registeryJobSeeker(@Valid @RequestBody JobSeeker jobSeeker){

        return ResponseEntity.ok(this.authService.registeryJobSeeker(jobSeeker));
    }

    @PostMapping("registeryEmployer")
    public ResponseEntity<?> registeryEmployer(@Valid @RequestBody Employer employer){

        return ResponseEntity.ok(this.authService.registeryEmployer(employer));
    }
    @GetMapping("alluser")
    public DataResult getAll(){
        return this.authService.getAll();
    }



    @PostMapping("loginDtoMail")
    public ResponseEntity<?> loginDtoMail(@Valid @RequestBody UserLoginDto userLoginDto){
        return ResponseEntity.ok(authService.loginDtoMail(userLoginDto));
    }

    @PostMapping("getCode")
    public ResponseEntity<?> getCode(@Valid @RequestBody int id){
        return ResponseEntity.ok(authService.getCode(id));
    }

    @PostMapping("verifyCode")
    public ResponseEntity<?> verifyCode(@Valid @RequestBody VerifyCodeUserDto verifyCodeUserDto){
        return ResponseEntity.ok(authService.verifyCode(verifyCodeUserDto.getCode(),verifyCodeUserDto.getId()));
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
