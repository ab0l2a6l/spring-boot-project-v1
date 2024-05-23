package com.example.springbootproject.entity;

import com.example.springbootproject.enums.AcademicLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {

    @Column(unique = true, nullable = false, updatable = false)
    private long stdNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicLevel academicLevel;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
}
