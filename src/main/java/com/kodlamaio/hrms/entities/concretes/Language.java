package com.kodlamaio.hrms.entities.concretes;

import com.kodlamaio.hrms.entities.concretes.users.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="language_name")
    private String languageName;

    @Column(name="level")
    private int level;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey( name = "job_seeker_id"))
    private JobSeeker jobSeekers;
}
