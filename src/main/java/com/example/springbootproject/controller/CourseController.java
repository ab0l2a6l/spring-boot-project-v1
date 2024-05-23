package com.example.springbootproject.controller;

import com.example.springbootproject.dto.course.AddCourseDTO;
import com.example.springbootproject.dto.course.UpdateCourseDTO;
import com.example.springbootproject.dto.course.ViewCourseDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.mapper.CourseMapper;
import com.example.springbootproject.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course/v1")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewCourseDTO save(@RequestBody AddCourseDTO addCourseDTO) {
        Course course = courseService.save(courseMapper.toEntity(addCourseDTO));
        return courseMapper.toViewDTO(course);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewCourseDTO update(@RequestBody UpdateCourseDTO updateCourseDTO) {
        Course course = courseService.update(courseMapper.toEntity(updateCourseDTO));
        return courseMapper.toViewDTO(course);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        courseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewCourseDTO findById(@PathVariable long id) {
        return courseMapper.toViewDTO(courseService.findById(id));
    }

    @GetMapping("/findAll")
    public List<Course> findAll() {
        return courseService.findAll();
    }
}
