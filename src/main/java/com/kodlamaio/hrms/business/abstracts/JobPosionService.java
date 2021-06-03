package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPosionService {
    DataResult<List<JobPosition>> getAll();
    Result addJobPosition(JobPosition jobPosition);


}
