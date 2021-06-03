package com.kodlamaio.hrms.business.abstracts.accounts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.SystemUser;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;

import java.util.List;

public interface SystemUserService {
    DataResult<List<User>> getAllUsers();

    Result add(User user);

    Result confirmEmployer(int id);

    Result login(UserLoginDto userLoginDto);

    Result register(SystemUser systemUser);


}
