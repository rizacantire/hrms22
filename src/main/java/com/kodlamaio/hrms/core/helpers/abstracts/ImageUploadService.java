package com.kodlamaio.hrms.core.helpers.abstracts;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageUploadService {
    DataResult<Map<String,String>> uploadImage(MultipartFile image);

}
