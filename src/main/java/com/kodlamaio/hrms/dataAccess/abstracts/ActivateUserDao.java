package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.users.ActivateUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivateUserDao extends JpaRepository<ActivateUser,Integer> {
    Result findActivateUserByUserId(int userId);
}
