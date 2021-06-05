package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.CityService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.City;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities/")

public class CitiesController {

    private CityService cityService;

    public CitiesController( CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(name = "getall")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }

    @PostMapping(name = "add")
    public Result add(@RequestBody City city){
        return this.cityService.add(city);
    }
}
