package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;

import javax.xml.crypto.Data;
import java.util.List;

public interface SystemUserService {
    DataResult<List<User>> getAllUsers();

    Result add(User user);

    Result confirmEmployer(Employer employer);


}
