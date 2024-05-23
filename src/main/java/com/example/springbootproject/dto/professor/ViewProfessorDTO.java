package com.example.springbootproject.dto.professor;

import com.example.springbootproject.dto.user.ViewUserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ViewProfessorDTO extends ViewUserDTO {
    private long code;
    private String academicRank;
    private List<Integer> courseCodes;
}
