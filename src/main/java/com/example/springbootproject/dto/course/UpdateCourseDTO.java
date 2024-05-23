package com.example.springbootproject.dto.course;

import com.example.springbootproject.dto.base.UpdateBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpdateCourseDTO extends UpdateBaseDTO {

    @NotBlank
    private String title;

    @Positive
    private int units;
}
