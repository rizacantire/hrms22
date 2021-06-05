package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.usersDto.JobSeekerSchool;

import java.util.List;

public interface JobSeekerSchoolService {

    Result add(JobSeekerSchool jobSeekerSchool);
    DataResult<List<JobSeekerSchool>> getAll();
}
