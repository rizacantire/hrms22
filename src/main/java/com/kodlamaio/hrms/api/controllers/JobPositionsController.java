package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.JobPosionService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/job_positions/")
public class JobPositionsController {

    private JobPosionService jobPosionService;

    public JobPositionsController(JobPosionService jobPosionService) {
        this.jobPosionService = jobPosionService;
    }

    @GetMapping("getall")
    public DataResult getAll(){
        return this.jobPosionService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> addJobPosition(@Valid @RequestBody JobPosition jobPosition){
        return ResponseEntity.ok(this.jobPosionService.addJobPosition(jobPosition));
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
