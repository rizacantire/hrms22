package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.AuthService;
import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.registry.Registry;
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
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Üye kaydı gerçekleşti.");
    }

    public Result registeryEmployer(Employer employer) {
            this.employerDao.save(employer);
            return new SuccessResult("Üye kaydı gerçekleşti.");

    }

    @Override
    public Result login(String mail, String password) {
        return null;
    }

    @Override
    public Result verifyAccount(String verifyCode) {
        return null;
    }
}
