package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activate_user")
public class ActivateUser extends User {

    @Column(name = "is_active")
    private boolean isActive;
}
