package com.kodlamaio.hrms.business.concretes.accounts;

import com.kodlamaio.hrms.business.abstracts.accounts.JobSeekerService;
import com.kodlamaio.hrms.core.helpers.abstracts.ImageUploadService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private ImageUploadService imageUploadService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao) {

        this.jobSeekerDao = jobSeekerDao;
    }
    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,ImageUploadService imageUploadService) {

        this.jobSeekerDao = jobSeekerDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if(this.jobSeekerDao.findAllByNationalityId(jobSeeker.getNationalityId()).stream().count() != 0){
            return new ErrorResult("Tc No sistemde kayıtlı");
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("İş arayan başarıyla eklendi");
    }

    @Override
    public Result addImage(int id, MultipartFile image) {
        Map<String, String> result = imageUploadService.uploadImage(image).getData();
        String url = result.get("url");
        var jobSeeker = this.jobSeekerDao.findByJobSeekerId(id);
        jobSeeker.setPicture(url);
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Resim Ekleme Başarılı");
    }

}
