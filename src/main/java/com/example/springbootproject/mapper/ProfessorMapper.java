package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.professor.AddProfessorDTO;
import com.example.springbootproject.dto.professor.UpdateProfessorDTO;
import com.example.springbootproject.dto.professor.ViewProfessorDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Professor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProfessorMapper {
    private final ModelMapper mapper;

    public Professor toEntity(AddProfessorDTO addProfessorDTO) {
        return mapper.map(addProfessorDTO, Professor.class);
    }

    public Professor toEntity(UpdateProfessorDTO updateProfessorDTO) {
        return mapper.map(updateProfessorDTO, Professor.class);
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
