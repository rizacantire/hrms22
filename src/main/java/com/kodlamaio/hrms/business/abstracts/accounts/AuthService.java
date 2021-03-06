package com.kodlamaio.hrms.business.abstracts.accounts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.users.Employer;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import com.kodlamaio.hrms.entities.concretes.users.VerifyCode;
import com.kodlamaio.hrms.entities.dtos.UserLoginDto;

import java.util.List;

public interface AuthService {

    DataResult<List<User>> getAll();

    Result registery(User user);

    Result login(String mail,String password);


    Result registeryJobSeeker(JobSeeker jobSeeker);

    Result registeryEmployer(Employer employer);


    Result loginJobSeekerDto(UserLoginDto userLoginDto);

    Result loginEmployerDto(UserLoginDto userLoginDto);

    DataResult<VerifyCode> getCode(int id);

    boolean checkCode(int id);

    Result verifyCode(String code,int id);



}
