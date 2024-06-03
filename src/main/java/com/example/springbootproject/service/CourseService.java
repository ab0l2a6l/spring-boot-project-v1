package com.example.springbootproject.service;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Professor;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.exception.ConflictException;
import com.example.springbootproject.exception.NotFoundException;
import com.example.springbootproject.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ProfessorService professorService;
    private final StudentService studentService;

    public Course save(Course course) {
        Optional<Course> findCourseByCode = courseRepository.findByCode(course.getCode());
        if (findCourseByCode.isPresent()) {
            throw new ConflictException("this course is available in the system");
        }
        return courseRepository.save(course);
    }

    public Course update(Course courseUpdate) {
        Course course = findById(courseUpdate.getId());

        courseUpdate.setCode(course.getCode());

        return courseRepository.save(courseUpdate);
    }

    public void deleteById(long id) {
        findById(id);
        courseRepository.deleteById(id);
    }

    public void deleteAll() {
        courseRepository.deleteAll();
    }

    public void removeStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);

        if (!course.getStudents().contains(student))
            throw new NotFoundException("The student does not have this course.");
        course.getStudents().remove(student);
        student.getCourses().remove(course);

        studentService.update(student);
        update(course);
    }


    public Course findById(long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            throw new NotFoundException("course not found");
        }
        return course.get();
    }

    public Course findByCode(int code) {
        Optional<Course> optional = courseRepository.findByCode(code);
        if (optional.isEmpty())
            throw new NotFoundException("Course Not found.");
        return optional.get();
    }


    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void addStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);

        course.getStudents().add(student);
        student.getCourses().add(course);

        studentService.update(student);
        update(course);
    }

    public void addProfessor(int codeCourse, int codeProfessor) {
        Professor professor = professorService.findByCode(codeProfessor);
        Course course = findByCode(codeCourse);

        course.setProfessor(professor);
        professor.getCourses().add(course);

        professorService.update(professor);
        update(course);
    }

    public List<Student> listStudents(int codeCourse) {
        return findByCode(codeCourse).getStudents().stream().toList();
    }

    public void removeProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");

        Professor professor = course.getProfessor();
        course.setProfessor(null);

        professor.getCourses().remove(course);

        professorService.update(professor);
        update(course);
    }

    public Professor getProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");
        return course.getProfessor();
    }
}
