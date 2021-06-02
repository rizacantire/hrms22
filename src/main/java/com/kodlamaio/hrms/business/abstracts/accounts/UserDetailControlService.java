package com.kodlamaio.hrms.business.abstracts.accounts;

import com.kodlamaio.hrms.core.utilities.results.Result;

public interface UserDetailControlService {
    Result checkNationalId();

    Result checkMailIsExist();
}
