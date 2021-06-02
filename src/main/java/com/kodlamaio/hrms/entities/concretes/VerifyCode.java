package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verify_codes")
@Entity
public class VerifyCode {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "verify_code")
    private String verifyCode;

    @Column(name = "is_code_verified")
    private boolean codeVerified;

    @Column(name = "user_id")
    private int userId;



}
