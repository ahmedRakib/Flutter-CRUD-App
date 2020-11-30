package com.bwma.backend.service;

import com.bwma.backend.model.Student;
import com.bwma.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public Student findOneStudent(Long id) {

    return studentRepository.findStudentById(id);

  }

  public List<Student> findAllStudents() {

    return studentRepository.findAll();

  }

  public Student save(Student student) {

    return studentRepository.save(student);

  }

  public Student updateStudent(Student student, Long id) {

    if (student.getId() == null || !student.getId().equals(id)) {

      throw new RuntimeException("id in payload and url do not match");

    }

    return studentRepository.save(student);

  }

  public void deleteStudent(Long id) {

    studentRepository.deleteById(id);

  }

}
