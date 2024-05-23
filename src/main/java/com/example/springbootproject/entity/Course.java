package com.example.springbootproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends BaseEntity {

    @Column(unique = true, nullable = false)
    private int code;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int units;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> students = new HashSet<>();
}
