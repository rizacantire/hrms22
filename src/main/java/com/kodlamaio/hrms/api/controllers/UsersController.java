package com.kodlamaio.hrms.api.controllers;

import com.kodlamaio.hrms.business.abstracts.UserService;
import com.kodlamaio.hrms.core.entities.User;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    @GetMapping("getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }


}
