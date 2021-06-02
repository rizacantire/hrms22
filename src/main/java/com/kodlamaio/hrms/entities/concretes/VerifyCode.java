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
@PrimaryKeyJoinColumn(name="verify_code_id",referencedColumnName = "user_id")
public class VerifyCode extends User {


    @Column(name = "verify_code")
    private String verifyCode;

    @Column(name = "is_code_verified")
    private boolean isCodeVerified;


}
