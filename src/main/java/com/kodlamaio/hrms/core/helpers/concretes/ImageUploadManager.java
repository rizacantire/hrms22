package com.kodlamaio.hrms.core.helpers.concretes;

import com.cloudinary.utils.ObjectUtils;
import com.kodlamaio.hrms.core.helpers.abstracts.ImageUploadService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;

import java.io.IOException;
import java.util.Map;

public class ImageUploadManager implements ImageUploadService {
    @Override
    public DataResult<Map<String, String>> uploadImage(MultipartFile image) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dmdztq03l", "api_key",
                "641529163195658", "api_secret", "vRIFpvYYskJPX7rcNNndvLDPw1s"));
        try {
            Map<String, String> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map<String, String>>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<Map<String, String>>();
    }
}
