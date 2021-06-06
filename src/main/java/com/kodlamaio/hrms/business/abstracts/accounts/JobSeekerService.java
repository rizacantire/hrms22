package com.kodlamaio.hrms.business.abstracts.accounts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    Result addImage(int jobSeekerId, MultipartFile image);
}
