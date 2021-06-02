package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "verified_user")
@PrimaryKeyJoinColumn(name="verified_user_id",referencedColumnName = "user_id")
public class VerifiedUser extends User {

    @Column(name = "is_verified")
    private boolean isVerified;
}
