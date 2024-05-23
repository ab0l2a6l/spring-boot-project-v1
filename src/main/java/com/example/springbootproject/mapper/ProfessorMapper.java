package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.professor.AddProfessorDTO;
import com.example.springbootproject.dto.professor.UpdateProfessorDTO;
import com.example.springbootproject.entity.Professor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
