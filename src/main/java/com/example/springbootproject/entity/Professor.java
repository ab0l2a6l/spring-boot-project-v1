package com.example.springbootproject.entity;

import com.example.springbootproject.enums.AcademicRank;
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
public class Professor extends User {

    @Column(unique = true, nullable = false, updatable = false)
    private int code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicRank academicRank;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();
}
