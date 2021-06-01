package com.kodlamaio.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Email
    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name="mail")
    private String mail;


    @NotEmpty
    @NotBlank
    @NotNull
    @Column(name="password")
    private String password;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private JobSeeker jobSeeker;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Employer employer;





}
