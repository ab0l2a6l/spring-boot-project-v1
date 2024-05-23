package com.example.springbootproject.dto.student;

import com.example.springbootproject.dto.user.UpdateUserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateStudentDTO extends UpdateUserDTO {

    @NotBlank
    private String academicLevel;
}
