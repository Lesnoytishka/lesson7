package com.lesnoytishka.cotroller;

import com.lesnoytishka.entity.Student;
import com.lesnoytishka.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/students/v1")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Student saveStudent(@RequestBody Student student) {
        return studentService.addOrUpdate(student);
    }

    @DeleteMapping("/{id}/remove")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.remove(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
}
