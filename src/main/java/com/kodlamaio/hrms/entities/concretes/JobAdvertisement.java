package com.kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "job_position_id")
    private int jobPositionId;

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "number")
    private int number;

    @Column(name = "last_application_date")
    private Date lastApplicationDate;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

}
