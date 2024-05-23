package com.example.springbootproject.dto.student;

import com.example.springbootproject.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddStudentDTO extends AddUserDTO {
    @Positive
    private long stdNumber;

    @NotBlank
    private String academicLevel;
}
