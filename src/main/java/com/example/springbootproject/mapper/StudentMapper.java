package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.student.AddStudentDTO;
import com.example.springbootproject.dto.student.UpdateStudentDTO;
import com.example.springbootproject.dto.student.ViewStudentDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final ModelMapper mapper;

    public Student toEntity(AddStudentDTO addStudentDTO) {
        return mapper.map(addStudentDTO, Student.class);
    }

    public Student toEntity(UpdateStudentDTO updateStudentDTO) {
        return mapper.map(updateStudentDTO, Student.class);
    }

    public ViewStudentDTO toViewDTO(Student student) {
        ViewStudentDTO viewStudentDTO = mapper.map(student, ViewStudentDTO.class);

        List<Integer> courseCodes = student.getCourses().stream().map(Course::getCode).toList();

        viewStudentDTO.setCourseCodes(courseCodes);
        viewStudentDTO.setBirthDay(student.getBirthDay().getTime());
        viewStudentDTO.setGender(student.getGender().name());

        return viewStudentDTO;
    }

    public List<ViewStudentDTO> toListViewDTO(List<Student> studentList) {
        return studentList.stream().map(this::toViewDTO).toList();
    }

}
