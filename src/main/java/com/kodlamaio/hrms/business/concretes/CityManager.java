package com.kodlamaio.hrms.business.concretes;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.*;
import com.kodlamaio.hrms.dataAccess.abstracts.CityDao;
import com.kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    private CityDao cityDao;


    @Override
    public Result add(City city) {
        var result = this.cityDao.findAllByName(city.getName());
        if (result == null){
            this.cityDao.save(city);
            return new SuccessResult("Şehir ismi sisteme kaydedildi Kaydedildi");

        }else {
            System.out.println(result);
            return new ErrorResult("Şehir ismi sistemde kayıtlı");

        }

    }


    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler getirildi");
    }
}
