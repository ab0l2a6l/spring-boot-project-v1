package com.example.springbootproject.mapper;

import com.example.springbootproject.dto.course.AddCourseDTO;
import com.example.springbootproject.dto.course.UpdateCourseDTO;
import com.example.springbootproject.dto.course.ViewCourseDTO;
import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseMapper {
    private final ModelMapper mapper;

    public Course toEntity(AddCourseDTO addCourseDTO) {
        return mapper.map(addCourseDTO, Course.class);
    }

    public Course toEntity(UpdateCourseDTO updateCourseDTO) {
        return mapper.map(updateCourseDTO, Course.class);
    }

    public ViewCourseDTO toViewDTO(Course course) {
        ViewCourseDTO viewCourseDTO = mapper.map(course, ViewCourseDTO.class);

        if (course.getProfessor() != null) {
            String professor = course.getProfessor().getName() + " " + course.getProfessor().getFamily();
            viewCourseDTO.setNameProfessor(professor);
        }

        List<Long> studentNumbers = course.getStudents().stream()
                .map(Student::getStdNumber)
                .toList();
        viewCourseDTO.setStudentNumbers(studentNumbers);

        return viewCourseDTO;
    }

}
