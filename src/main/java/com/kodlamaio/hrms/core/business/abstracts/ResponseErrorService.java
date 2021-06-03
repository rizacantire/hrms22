package com.kodlamaio.hrms.core.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface ResponseErrorService {
    ErrorDataResult<Object> handleValidationException (MethodArgumentNotValidException exceptions);
}
