package com.example.springbootproject.service;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.exception.ConflictException;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student save(Student student) {
        Optional<Student> optionalStudent;
        optionalStudent = studentRepository.findByStdNumber(student.getStdNumber());
        if (optionalStudent.isPresent()) {
            throw new ConflictException("the student with desired student number is available in the system");
        }
        optionalStudent = studentRepository.findByNationalCode(student.getNationalCode());
        if (optionalStudent.isPresent()) {
            throw new ConflictException("the student with desired national code is available in the system");
        }
        optionalStudent = studentRepository.findByUsername(student.getUsername());
        if (optionalStudent.isPresent()) {
            throw new ConflictException("the student with desired username is available in the system");
        }
        return studentRepository.save(student);
    }

    public Student update(Student studentUpdate) {
        Student student = findById(studentUpdate.getId());

        studentUpdate.setNationalCode(student.getNationalCode());
        studentUpdate.setStdNumber(student.getStdNumber());
        studentUpdate.setUsername(student.getUsername());

        return studentRepository.save(studentUpdate);
    }

    public void deleteById(long id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public Student findById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new NotFoundException("student not found");
        }
        return student.get();
    }

    public Student findByStdNumber(long stdNumber) {
        Optional<Student> student = studentRepository.findByStdNumber(stdNumber);
        if (student.isEmpty()) {
            throw new NotFoundException("student not found");
        }
        return student.get();
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Course> listCoursesStudent(long stdNumber) {
        Student student = findByStdNumber(stdNumber);
        return student.getCourses().stream().toList();
    }
}
