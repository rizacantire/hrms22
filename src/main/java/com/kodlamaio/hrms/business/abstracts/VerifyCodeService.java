package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.dataAccess.abstracts.VerifyCodeDao;
import com.kodlamaio.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeService {
    DataResult<VerifyCode> sendCode(VerifyCode verifyCode);
    Result verifiedCodeByUser(String code);
    DataResult<VerifyCode> isVerified(int id);

}
