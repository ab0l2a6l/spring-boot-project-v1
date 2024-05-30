package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.professor.AddProfessorDTO;
import com.example.springbootproject.dto.professor.UpdateProfessorDTO;
import com.example.springbootproject.dto.professor.ViewProfessorDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Professor;
import com.example.springbootproject.enums.Gender;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProfessorMapper {
    private final ModelMapper mapper;

    public Professor toEntity(AddProfessorDTO addProfessorDTO) {
        Professor professor = mapper.map(addProfessorDTO, Professor.class);

        professor.setGender(addProfessorDTO.getGender().equals("MALE") ? Gender.MALE : Gender.FEMALE);
        professor.setBirthDay(new Date(addProfessorDTO.getBirthDayTimeStamp()));

        return professor;
    }

    public Professor toEntity(UpdateProfessorDTO updateProfessorDTO) {
        Professor professor = mapper.map(updateProfessorDTO, Professor.class);

        professor.setGender(updateProfessorDTO.getGender().equals("MALE") ? Gender.MALE : Gender.FEMALE);
        professor.setBirthDay(new Date(updateProfessorDTO.getBirthDay()));

        return professor;
    }


    public ViewProfessorDTO toViewDTO(Professor professor) {
        ViewProfessorDTO viewProfessorDTO = mapper.map(professor, ViewProfessorDTO.class);

        Set<Course> courses = professor.getCourses();
        List<Integer> courseCodes = courses.stream().map(Course::getCode).toList();

        viewProfessorDTO.setCourseCodes(courseCodes);

        viewProfessorDTO.setBirthDay(professor.getBirthDay().getTime());

        viewProfessorDTO.setGender(professor.getGender().name());

        return viewProfessorDTO;
    }

    public List<ViewProfessorDTO> toListViewDTO(List<Professor> professorList) {
        return professorList.stream().map(this::toViewDTO).toList();
    }

}
