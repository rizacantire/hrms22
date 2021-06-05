package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.users.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserDao extends JpaRepository<SystemUser,Integer> {
    SystemUser findByMail(String mail);

}
