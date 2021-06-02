package com.kodlamaio.hrms.business.concretes.accounts;

import com.kodlamaio.hrms.business.abstracts.accounts.AuthService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthManager implements AuthService {

    private UserDao userDao;
    private JobSeekerDao jobSeekerDao;
    private EmployerDao employerDao;


    @Autowired
    public AuthManager(UserDao userDao,JobSeekerDao jobSeekerDao,EmployerDao employerDao) {
        this.userDao = userDao;
        this.jobSeekerDao = jobSeekerDao;
        this.employerDao = employerDao;

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
                return new SuccessResult("Üye kaydı gerçekleşti.");
            }
        }
    }

    public Result registeryEmployer(Employer employer) {
        if(this.userDao.findAllByMail(employer.getMail()).stream().count() !=0){
            return new ErrorResult("Mail adresi sistemde kayıtlı");
        }else {

            this.employerDao.save(employer);
            return new SuccessResult("Üye kaydı gerçekleşti.");
        }

    }

    @Override
    public Result loginDtoMail(UserLoginDto userLoginDto) {
        User mailCheck = userDao.findByMail(userLoginDto.getMail());
        if(mailCheck == null){
            return new ErrorResult("Mail adresi sistemde kayıtlı değil");
        }
        if (mailCheck.getMail().equals(userLoginDto.getMail()) & mailCheck.getPassword().equals(userLoginDto.getPassword())){
            return new SuccessResult("giriş başarılı");
        }else {
            return new ErrorResult("Hatalı giriş");
        }
    }


    @Override
    public Result login(String mail, String password) {

        return null;
    }

}
