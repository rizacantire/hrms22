package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobSeekerSchoolService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerSchoolDao;
import com.kodlamaio.hrms.entities.concretes.usersDto.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService {

    private JobSeekerSchoolDao jobSeekerSchoolDao;
    @Autowired
    public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao) {
        this.jobSeekerSchoolDao = jobSeekerSchoolDao;
    }

    @Override
    public Result add(JobSeekerSchool jobSeekerSchool) {
        this.jobSeekerSchoolDao.save(jobSeekerSchool);
        return new SuccessResult("Okul bilgileri eklendi");
    }

    @Override
    public DataResult<List<JobSeekerSchool>> getAll() {
        return new SuccessDataResult<List<JobSeekerSchool>>(this.jobSeekerSchoolDao.findAll());
    }
}
