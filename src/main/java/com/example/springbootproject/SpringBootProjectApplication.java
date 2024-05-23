package com.example.springbootproject;

import com.example.springbootproject.entity.Course;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.enums.AcademicLevel;
import com.example.springbootproject.enums.Gender;
import com.example.springbootproject.service.CourseService;
import com.example.springbootproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootProjectApplication implements CommandLineRunner {

    private final CourseService courseService;
    private final StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if(courseService.findAll().isEmpty()){
            Course course = new Course();
            course.setCode(4);
            course.setTitle("course4");
            course.setUnits(3);
            course = courseService.save(course);

            Student student = new Student();
            student.setName("name1");
            student.setFamily("family1");
            student.setBirthDay(new Date());
            student.setGender(Gender.FEMALE);
            student.setStdNumber(1234567890L);
            student.setAcademicLevel(AcademicLevel.PHD);
            student.setNationalCode(9876543210L);
            student.setUsername("username1");
            student.setPassword("password1");
            studentService.save(student);

            course.getStudents().add(student);
            courseService.update(course);
        }

    }
}
