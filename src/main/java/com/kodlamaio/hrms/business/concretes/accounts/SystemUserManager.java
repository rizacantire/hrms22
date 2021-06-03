package com.kodlamaio.hrms.business.concretes.accounts;

import com.kodlamaio.hrms.business.abstracts.accounts.SystemUserService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.SystemUserDao;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.SystemUser;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserManager implements SystemUserService {
    private UserDao userDao;
    private EmployerDao employerDao;
    private JobSeekerDao jobSeekerDao;
    private SystemUserDao systemUserDao;

    @Autowired
    public SystemUserManager(UserDao userDao, EmployerDao employerDao, JobSeekerDao jobSeekerDao,SystemUserDao systemUserDao) {
        this.userDao = userDao;
        this.employerDao = employerDao;
        this.jobSeekerDao = jobSeekerDao;
        this.systemUserDao = systemUserDao;
    }

    @Override
    public DataResult<List<User>> getAllUsers() {

        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public Result confirmEmployer(int id) {
        var user = this.employerDao.findByUserId(id);
        user.setActivated(true);

        this.employerDao.saveAndFlush(user);
        return new SuccessResult("Employer kaydı onaylandı.");
    }

    @Override
    public Result login(UserLoginDto userLoginDto) {
        User mailCheck = systemUserDao.findByMail(userLoginDto.getMail());

        if(mailCheck == null){
            return new ErrorResult("Böyle bir sistem kullanıcısı kayıtlı değil.");
        }
        if (mailCheck.getMail().equals(userLoginDto.getMail()) & mailCheck.getPassword().equals(userLoginDto.getPassword())){
            if (checkIsSystemUser(mailCheck.getUserId())==true){
                return new SuccessResult("giriş başarılı");
            }else {
                return new ErrorResult("Doğrulama yapılmamış hesap");
            }

        }else {
            return new ErrorResult("Hatalı giriş");
        }
    }

    @Override
    public Result register(SystemUser systemUser) {
        var users = this.userDao.findAllByMail(systemUser.getMail());
        if (users.stream().count() ==0){
            this.systemUserDao.save(systemUser);
            return new SuccessResult("Kayıt başarılı");
        }
        else {
            return new ErrorResult("Hatalı giriş");
        }

    }

    public boolean checkIsSystemUser(int id){
        var accounts = this.systemUserDao.findById(id);
        return accounts.get().isAdmin();

    }
}
