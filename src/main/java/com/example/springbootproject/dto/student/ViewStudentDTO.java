package com.example.springbootproject.dto.student;

import com.example.springbootproject.dto.user.ViewUserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ViewStudentDTO extends ViewUserDTO {

    private long stdNumber;
    private String academicLevel;
    private List<Integer> courseCodes;
}
