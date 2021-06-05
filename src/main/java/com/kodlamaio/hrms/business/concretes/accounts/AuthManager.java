package com.kodlamaio.hrms.business.concretes.accounts;

import com.kodlamaio.hrms.business.abstracts.accounts.AuthService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.VerifyCodeDao;
import com.kodlamaio.hrms.entities.concretes.users.Employer;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import com.kodlamaio.hrms.entities.concretes.users.VerifyCode;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AuthManager implements AuthService {

    private UserDao userDao;
    private JobSeekerDao jobSeekerDao;
    private EmployerDao employerDao;
    private VerifyCodeDao verifyCodeDao;


    @Autowired
    public AuthManager(UserDao userDao,JobSeekerDao jobSeekerDao,EmployerDao employerDao, VerifyCodeDao verifyCodeDao) {
        this.userDao = userDao;
        this.jobSeekerDao = jobSeekerDao;
        this.employerDao = employerDao;
        this.verifyCodeDao = verifyCodeDao;

    }

    @Override
    public DataResult<List<User>> getAll() {

        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }
    @Override
    public Result registery(User user) {
        if(this.userDao.findAllByMail(user.getMail()).stream().count() !=0){
            return new ErrorResult("Mail adresi sistemde kayıtlı");
        }else {
            this.userDao.save(user);
            return new SuccessResult("Üye kaydı gerçekleşti.");
        }
    }

    public Result registeryJobSeeker(JobSeeker jobSeeker) {
        if(this.userDao.findAllByMail(jobSeeker.getMail()).stream().count() !=0){
            return new ErrorResult("Mail adresi sistemde kayıtlı");
        }else {
            if(jobSeekerDao.findAllByNationalityId(jobSeeker.getNationalityId()).stream().count()!=0){
                return new ErrorResult("Tc No sistemde kayıtlı");
            }else {
                this.jobSeekerDao.save(jobSeeker);
                this.generateVerifyCode(jobSeeker);
                return new SuccessResult("Üye kaydı gerçekleşti.");
            }
        }
    }

    public Result generateVerifyCode(User user){
        Random random= new Random();
        int code = 100000 + random.nextInt(899999);
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setVerifyCode(String.valueOf(code));
        verifyCode.setUserId(user.getUserId());
        this.verifyCodeDao.save(verifyCode);
        return new SuccessResult("Doğrulama kodu gönderildi");
    }

    public Result registeryEmployer(Employer employer) {
        if(this.userDao.findAllByMail(employer.getMail()).stream().count() !=0){
            return new ErrorResult("Mail adresi sistemde kayıtlı");
        }else {
            if (isEmployerMailAvaible(employer)){
                this.employerDao.save(employer);
                return new SuccessResult("Üye kaydı gerçekleşti.");
            }else {
                return new ErrorResult("Domain'e kayıtlı mail adresi girmelisiniz");
            }

        }

    }
    public boolean isEmployerMailAvaible(Employer employer){
        var checkLast =employer.getMail().split("@");
        var check = checkLast[1].equals(employer.getWebSite());
        if(check){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Result loginJobSeekerDto(UserLoginDto userLoginDto) {
        User mailCheck = userDao.findByMail(userLoginDto.getMail());



        if(mailCheck == null){
            return new ErrorResult("Mail adresi sistemde kayıtlı değil");
        }
        if (mailCheck.getMail().equals(userLoginDto.getMail()) & mailCheck.getPassword().equals(userLoginDto.getPassword())){
            if (checkCode(mailCheck.getUserId())==true){
                return new SuccessResult("giriş başarılı");
            }else {
                return new ErrorResult("Doğrulama yapılmamış hesap");
            }

        }else {
            return new ErrorResult("Hatalı giriş");
        }
    }

    @Override
    public Result loginEmployerDto(UserLoginDto userLoginDto) {
        User mailCheck = userDao.findByMail(userLoginDto.getMail());



        if(mailCheck == null){
            return new ErrorResult("Mail adresi sistemde kayıtlı değil");
        }
        if (mailCheck.getMail().equals(userLoginDto.getMail()) & mailCheck.getPassword().equals(userLoginDto.getPassword())){
            if (checkActivation(mailCheck.getUserId())==true){
                return new SuccessResult("giriş başarılı");
            }else {
                return new ErrorResult("Doğrulama yapılmamış hesap");
            }

        }else {
            return new ErrorResult("Hatalı giriş");
        }
    }


    @Override
    public Result login(String mail, String password) {

        return null;
    }

    @Override
    public DataResult<VerifyCode> getCode(int id) {

        return new SuccessDataResult<VerifyCode>(this.verifyCodeDao.findVerifyCodeByUserId(id));
    }

    @Override
    public boolean checkCode(int id) {
        var codes = getCode(id);
        if (codes.getData().isCodeVerified() == true){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkActivation(int id){
        var accounts = this.employerDao.findById(id);
        return accounts.get().isActivated();

    }

    @Override
    public Result verifyCode(String code,int id) {
        var codes = getCode(id);
        if(codes.getData().getVerifyCode().equals(code)){
            codes.getData().setCodeVerified(true);
            this.verifyCodeDao.save(codes.getData());
            return new SuccessResult("Doğrulama başarılı");
        }else {

            return new ErrorResult("Doğrulama kodu hatalı");
        }
    }


}
