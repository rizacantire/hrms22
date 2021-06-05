package com.kodlamaio.hrms.entities.concretes.usersDto;

import com.kodlamaio.hrms.entities.concretes.School;
import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_schools")
@Entity
public class JobSeekerSchool {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey( name = "job_seeker_id"))
    private JobSeeker jobSeeker;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey( name = "school_id"))
    private School school;


}
