package com.example.springbootproject.controller;

import com.example.springbootproject.dto.course.ViewCourseDTO;
import com.example.springbootproject.dto.student.AddStudentDTO;
import com.example.springbootproject.dto.student.UpdateStudentDTO;
import com.example.springbootproject.dto.student.ViewStudentDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.mapper.CourseMapper;
import com.example.springbootproject.mapper.StudentMapper;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student/v1")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewStudentDTO save(@RequestBody AddStudentDTO addStudentDTO) {
        return studentMapper.toViewDTO(studentService.save(studentMapper.toEntity(addStudentDTO)));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewStudentDTO update(@RequestBody UpdateStudentDTO updateStudentDTO) {
        return studentMapper.toViewDTO(studentService.update(studentMapper.toEntity(updateStudentDTO)));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public ViewStudentDTO findById(@PathVariable long id) {
        return studentMapper.toViewDTO(studentService.findById(id));
    }

    @GetMapping("/findByStdNumber/{stdNumber}")
    public ViewStudentDTO findByStdNumber(@PathVariable long stdNumber) {
        return studentMapper.toViewDTO(studentService.findByStdNumber(stdNumber));
    }

    @GetMapping("/findAll")
    public List<ViewStudentDTO> findAll() {
        return studentMapper.toListViewDTO(studentService.findAll());
    }

    @GetMapping("/{stdNumber}/course/list")
    public List<ViewCourseDTO> listCoursesStudent(@PathVariable long stdNumber) {
        List<Course> courses = studentService.listCoursesStudent(stdNumber);
        return courseMapper.toListViewDTO(courses);
    }
}
