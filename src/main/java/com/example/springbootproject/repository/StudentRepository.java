package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {
    Optional<Student> findByStdNumber(long stdNumber);
}
