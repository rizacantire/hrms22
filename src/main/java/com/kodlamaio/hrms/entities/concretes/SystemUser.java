package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system_user")
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "user_id")

public class SystemUser extends User {


    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

}
