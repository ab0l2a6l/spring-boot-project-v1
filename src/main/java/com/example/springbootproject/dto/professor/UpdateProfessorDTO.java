package com.example.springbootproject.dto.professor;

import com.example.springbootproject.dto.user.UpdateUserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateProfessorDTO extends UpdateUserDTO {

    @NotBlank
    private String academicRank;
}
