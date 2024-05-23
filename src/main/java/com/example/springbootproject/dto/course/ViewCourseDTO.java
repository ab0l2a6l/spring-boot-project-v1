package com.example.springbootproject.dto.course;

import com.example.springbootproject.dto.base.ViewBaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ViewCourseDTO extends ViewBaseDTO {
    private int code;
    private String title;
    private int units;
    private String nameProfessor;
    private List<Long> studentNumbers;
}
