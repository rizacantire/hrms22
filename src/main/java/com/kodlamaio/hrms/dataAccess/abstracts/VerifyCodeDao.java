package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.users.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyCodeDao extends JpaRepository<VerifyCode,Integer> {
    VerifyCode findVerifyCodeByUserId(int id);
}
