package com.kodlamaio.hrms.entities.concretes.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seeker")
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "user_id")

public class JobSeeker extends User {


    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "birth_date")
    private Date birthDate;



}
