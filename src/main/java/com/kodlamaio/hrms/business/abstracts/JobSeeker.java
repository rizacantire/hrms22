package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

public interface JobSeeker {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
}
