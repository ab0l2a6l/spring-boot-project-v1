package com.example.springbootproject.controller;


import com.example.springbootproject.entity.Professor;
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

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Professor save(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Professor update(@RequestBody Professor professor) {
        return professorService.update(professor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        professorService.deleteById(id);
    }

    @GetMapping("/findById/{id}")
    public Professor findById(@PathVariable long id) {
        return professorService.findById(id);
    }

    @GetMapping("/findByCode/{code}")
    public Professor findByCode(@PathVariable int code) {
        return professorService.findByCode(code);
    }

    @GetMapping("/findAll")
    public List<Professor> findAll() {
        return professorService.findAll();
    }
}
