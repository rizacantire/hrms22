package com.kodlamaio.hrms.business.abstracts.accounts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.users.Employer;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);

    Result addJobAdversitement(JobAdvertisement jobAdvertisement);
}
