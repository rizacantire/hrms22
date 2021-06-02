package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;

public interface VerifiedUserService {

    Result activateAccount(String code);
}
