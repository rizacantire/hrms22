package com.kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@Entity
public class School {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String name;

    @Column(name = "school_department")
    private String schoolDepartment;
}
