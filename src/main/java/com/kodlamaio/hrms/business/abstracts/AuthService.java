package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface AuthService {

    DataResult<List<User>> getAll();

    Result registery(User user);

    Result login(String mail,String password);

    Result verifyAccount(String verifyCode);

    Result registeryJobSeeker(JobSeeker jobSeeker);

    Result registeryEmployer(Employer employer);


}
