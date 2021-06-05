package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.VerifyCodeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.dataAccess.abstracts.VerifyCodeDao;
import com.kodlamaio.hrms.entities.concretes.users.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VerifyCodeManager implements VerifyCodeService {
    private VerifyCodeDao verifyCodeDao;

    @Autowired
    public VerifyCodeManager(VerifyCodeDao verifyCodeDao) {
        this.verifyCodeDao = verifyCodeDao;
    }

    @Override
    public DataResult<VerifyCode> sendCode(VerifyCode verifyCode) {
        Random rnd = new Random();
        int code = 100000 + rnd.nextInt(899999);
        verifyCode.setVerifyCode(String.valueOf(code));

        return new SuccessDataResult<VerifyCode>(this.verifyCodeDao.save(verifyCode),"Doğrulama kodu gönderildi");
    }

    @Override
    public Result verifiedCodeByUser(String code) {
        return null;
    }

    @Override
    public DataResult<VerifyCode> isVerified(int id) {

        return new SuccessDataResult<VerifyCode>(this.verifyCodeDao.findVerifyCodeByUserId(id));
    }
}
