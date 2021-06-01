package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seeker")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobSeeker {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    //@Column(name = "user_id")
    //private int userId;

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


    @OneToOne()
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;


}
