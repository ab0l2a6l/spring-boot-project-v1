package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
    Optional<Professor> findByCode(int code);
}
