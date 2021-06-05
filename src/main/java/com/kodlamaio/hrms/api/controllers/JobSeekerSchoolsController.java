package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.JobSeekerSchoolService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.usersDto.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekerschool/")
public class JobSeekerSchoolsController {
    private JobSeekerSchoolService jobSeekerSchoolService;

    @Autowired
    public JobSeekerSchoolsController(JobSeekerSchoolService jobSeekerSchoolService) {
        this.jobSeekerSchoolService = jobSeekerSchoolService;
    }

    @PostMapping("add")
    public Result add(@RequestBody JobSeekerSchool jobSeekerSchool){
        return this.jobSeekerSchoolService.add(jobSeekerSchool);
    }

    @GetMapping("getall")
    public Result getAll(){
        return this.jobSeekerSchoolService.getAll();
    }
}
