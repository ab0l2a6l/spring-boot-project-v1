package com.example.springbootproject.controller;

import com.example.springbootproject.dto.course.AddCourseDTO;
import com.example.springbootproject.dto.course.UpdateCourseDTO;
import com.example.springbootproject.dto.course.ViewCourseDTO;
import com.example.springbootproject.dto.professor.ViewProfessorDTO;
import com.example.springbootproject.dto.student.ViewStudentDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Professor;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.mapper.CourseMapper;
import com.example.springbootproject.mapper.ProfessorMapper;
import com.example.springbootproject.mapper.StudentMapper;
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
    private final StudentMapper studentMapper;
    private final ProfessorMapper professorMapper;
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
    public List<ViewCourseDTO> findAll() {
        return courseMapper.toListViewDTO(courseService.findAll());
    }

    @GetMapping("/{codeCourse}/students")
    @ResponseStatus(HttpStatus.OK)
    public List<ViewStudentDTO> listStudents(@PathVariable int codeCourse) {
        List<Student> students = courseService.listStudents(codeCourse);
        return studentMapper.toListViewDTO(students);
    }

    @PostMapping("/{codeCourse}/students/add/{stdNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void addStudent(@PathVariable int codeCourse, @PathVariable long stdNumber) {
        courseService.addStudent(codeCourse, stdNumber);
    }

    @DeleteMapping("/{codeCourse}/students/delete/{stdNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void removeStudent(@PathVariable int codeCourse, @PathVariable long stdNumber) {
        courseService.removeStudent(codeCourse, stdNumber);
    }
    @PostMapping("/{codeCourse}/professor/add/{codeProfessor}")
    @ResponseStatus(HttpStatus.OK)
    public void addProfessor(@PathVariable int codeCourse, @PathVariable int codeProfessor) {
        courseService.addProfessor(codeCourse, codeProfessor);
    }

    @DeleteMapping("/{codeCourse}/professor/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeStudent(@PathVariable int codeCourse) {
        courseService.removeProfessor(codeCourse);
    }

    @GetMapping("/{codeCourse}/professor")
    public ViewProfessorDTO getProfessor(@PathVariable int codeCourse) {
        Professor professor = courseService.getProfessor(codeCourse);
        return professorMapper.toViewDTO(professor);
    }
}
