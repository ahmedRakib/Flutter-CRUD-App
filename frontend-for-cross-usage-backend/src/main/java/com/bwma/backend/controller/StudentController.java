package com.bwma.backend.controller;

import com.bwma.backend.model.Student;
import com.bwma.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/api/student")
  public Student createStudent(@RequestBody @Valid Student student) {

    return studentService.save(student);

  }

  @GetMapping("/api/student/{id}")
  public Student findOneStudent(@PathVariable Long id) {

    return studentService.findOneStudent(id);

  }

  @GetMapping("/api/student")
  public List<Student> findAllStudents() {

    return studentService.findAllStudents();

  }

  @PutMapping("/api/student/{id}")
  public Student updateStudent(@RequestBody @Valid Student student, @PathVariable Long id) {

    return studentService.updateStudent(student, id);

  }

  @DeleteMapping("/api/student/{id}")
  public void deleteStudent(@PathVariable Long id) {

    studentService.deleteStudent(id);

  }

}
