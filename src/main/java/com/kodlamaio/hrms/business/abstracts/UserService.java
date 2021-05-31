package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;


import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<User> findByMail(String mail);
    DataResult<List<User>> getAll();
}
