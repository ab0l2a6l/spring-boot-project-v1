package com.example.springbootproject.service;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Professor;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.exception.ConflictException;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        Optional<Professor> optionalProfessor;
        optionalProfessor = professorRepository.findByCode(professor.getCode());
        if (optionalProfessor.isPresent()) {
            throw new ConflictException("the professor with desired code is available in the system");
        }
        optionalProfessor = professorRepository.findByNationalCode(professor.getNationalCode());
        if (optionalProfessor.isPresent()) {
            throw new ConflictException("the professor with desired national code is available in the system");
        }
        optionalProfessor = professorRepository.findByUsername(professor.getUsername());
        if (optionalProfessor.isPresent()) {
            throw new ConflictException("the professor with desired username is available in the system");
        }
        return professorRepository.save(professor);
    }

    public Professor update(Professor professorUpdate) {
        Professor professor = findById(professorUpdate.getId());

        professorUpdate.setNationalCode(professor.getNationalCode());
        professorUpdate.setUsername(professor.getUsername());
        professorUpdate.setCode(professor.getCode());

        return professorRepository.save(professorUpdate);
    }

    public void deleteById(long id) {
        findById(id);
        professorRepository.deleteById(id);
    }

    public Professor findById(long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isEmpty()) {
            throw new NotFoundException("professor not found");
        }
        return professor.get();
    }

    public Professor findByCode(int code) {
        Optional<Professor> professor = professorRepository.findByCode(code);
        if (professor.isEmpty()) {
            throw new NotFoundException("professor not found");
        }
        return professor.get();
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public List<Course> listCoursesProfessor(int code) {
        Professor professor = findByCode(code);
        return professor.getCourses().stream().toList();
    }
}
