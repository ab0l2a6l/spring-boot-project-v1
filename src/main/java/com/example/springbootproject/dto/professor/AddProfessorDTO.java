package com.example.springbootproject.dto.professor;

import com.example.springbootproject.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddProfessorDTO extends AddUserDTO {

    @Positive
    private int code;

    @NotBlank
    private String academicRank;
}
