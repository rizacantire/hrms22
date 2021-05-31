package com.kodlamaio.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Repeatable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

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
}
