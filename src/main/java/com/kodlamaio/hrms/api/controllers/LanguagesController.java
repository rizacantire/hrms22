package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages/")
public class LanguagesController {

    private LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("add")
    public Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

    @GetMapping("getall")
    public Result getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("getByJobSeeker")
    public Result getById(@RequestBody JobSeeker jobSeeker){
        return this.languageService.getByJobSeekerId(jobSeeker.getUserId());
    }
}
