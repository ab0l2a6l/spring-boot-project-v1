package com.example.springbootproject.service;

import com.example.springbootproject.entity.Course;
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

    public Course save(Course course) {
        Optional<Course> findCourseByCode = courseRepository.findByCode(course.getCode());
        if (findCourseByCode.isPresent()) {
            throw new ConflictException("this course is available in the system");
        }
        return courseRepository.save(course);
    }

    public Course findById(long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            throw new NotFoundException("course not found");
        }
        return course.get();
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

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
