package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.JobPosionService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import com.kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPosionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public Result addJobPosition(JobPosition jobPosition) {
       var result = this.jobPositionDao.findByName(jobPosition.getName());
       if (result == null){
           this.jobPositionDao.save(jobPosition);
           return new SuccessResult("Kayıt başarılı");
       }else {
           return new ErrorResult("İş pozisyonu sistemde kayıtlı");
       }

    }

    public JobPosition get(String jobPosition){
        var result = this.jobPositionDao.findJobPositionByName(jobPosition);
        return result;
    }

}
