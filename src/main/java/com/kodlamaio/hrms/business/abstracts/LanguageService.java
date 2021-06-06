package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);

    DataResult<List<Language>> getAll();

    DataResult<Language> getByJobSeekerId(int id);
}
