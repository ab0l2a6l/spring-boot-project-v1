package com.example.springbootproject.dto.course;

import com.example.springbootproject.dto.base.AddBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AddCourseDTO extends AddBaseDTO {
    @Positive
    private int code;

    @NotBlank
    private String title;

    @Positive
    private int units;
}
