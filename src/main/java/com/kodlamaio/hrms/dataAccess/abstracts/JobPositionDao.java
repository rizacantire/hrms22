package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

    JobPosition findJobPositionByName(String jobPositionName);
    JobPosition findByName(String jobPositionName);
}
