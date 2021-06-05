package com.kodlamaio.hrms.business.concretes.accounts;

import com.kodlamaio.hrms.business.abstracts.accounts.UserService;
import com.kodlamaio.hrms.core.dataAccess.UserDao;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;


    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Üye eklendi");
    }

    @Override
    public DataResult<User> findByMail(String mail) {
        return new SuccessDataResult<User>(this.userDao.findByMail(mail));
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

}
