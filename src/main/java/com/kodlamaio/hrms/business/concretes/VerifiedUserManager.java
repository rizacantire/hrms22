package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.VerifiedUserService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.VerifiedUserDao;

import java.util.Random;

public class VerifiedUserManager implements VerifiedUserService {
    private VerifiedUserDao verifiedUserDao;


    @Override
    public Result activateAccount(String code) {
        return null;
    }
}
