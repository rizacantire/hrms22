package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.usersDto.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool,Integer> {
}
