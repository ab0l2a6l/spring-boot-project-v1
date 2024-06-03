package com.example.springbootproject.controller;


import com.example.springbootproject.dto.course.ViewCourseDTO;
import com.example.springbootproject.dto.professor.AddProfessorDTO;
import com.example.springbootproject.dto.professor.UpdateProfessorDTO;
import com.example.springbootproject.dto.professor.ViewProfessorDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.mapper.CourseMapper;
import com.example.springbootproject.mapper.ProfessorMapper;
import com.example.springbootproject.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("professor/v1")
public class ProfessorController {

    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;
    private final CourseMapper courseMapper;;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewProfessorDTO save(@RequestBody AddProfessorDTO addProfessorDTO) {
        return professorMapper.toViewDTO(professorService.save(professorMapper.toEntity(addProfessorDTO)));
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewProfessorDTO update(@RequestBody UpdateProfessorDTO updateProfessorDTO) {
        return professorMapper.toViewDTO(professorService.update(professorMapper.toEntity(updateProfessorDTO)));
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        professorService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public ViewProfessorDTO findById(@PathVariable long id) {
        return professorMapper.toViewDTO(professorService.findById(id));
    }

    @GetMapping("/findByCode/{code}")
    public ViewProfessorDTO findByCode(@PathVariable int code) {
        return professorMapper.toViewDTO(professorService.findByCode(code));
    }

    @GetMapping("/findAll")
    public List<ViewProfessorDTO> findAll() {
        return professorMapper.toListViewDTO(professorService.findAll());
    }

    @GetMapping("/{codeProfessor}/course/list")
    public List<ViewCourseDTO> listCoursesProfessor(@PathVariable int codeProfessor) {
        List<Course> courses = professorService.listCoursesProfessor(codeProfessor);
        return courseMapper.toListViewDTO(courses);
    }
}
