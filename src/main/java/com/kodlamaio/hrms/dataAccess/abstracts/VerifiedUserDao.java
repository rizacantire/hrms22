package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.VerifiedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifiedUserDao extends JpaRepository<VerifiedUser,Integer> {
    Result findVerifiedUserByUserId(int userId);

}
