package com.kodlamaio.hrms.core.dataAccess;

import com.kodlamaio.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByMail(String mail);
}