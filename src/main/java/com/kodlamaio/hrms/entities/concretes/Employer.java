package com.kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")


public class Employer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    //@Column(name = "user_id")
    //private int userId;

    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;

    @Column(name = "web_site")
    @NotBlank
    @NotNull
    private String webSite;

    @Column(name = "phone")
    @NotBlank
    @NotNull
    private String phone;

    @OneToOne()
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;


}
