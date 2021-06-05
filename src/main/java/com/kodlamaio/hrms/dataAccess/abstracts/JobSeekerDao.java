package com.kodlamaio.hrms.dataAccess.abstracts;

import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    List<JobSeeker> findAllByNationalityId(String nationalityId);

}
