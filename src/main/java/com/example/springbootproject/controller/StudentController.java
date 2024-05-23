package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Professor;
import com.example.springbootproject.entity.Student;
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

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @GetMapping("/findByStdNumber/{stdNumber}")
    public Student findByStdNumber(@PathVariable long stdNumber) {
        return studentService.findByStdNumber(stdNumber);
    }

    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
