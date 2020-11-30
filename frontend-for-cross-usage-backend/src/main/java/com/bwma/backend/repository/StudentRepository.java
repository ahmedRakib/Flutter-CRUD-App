package com.bwma.backend.repository;

import com.bwma.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("select s from Student s where s.id = :id")
  Student findStudentById(Long id);

  @Query("select s from Student s where s.name like '%:name%'")
  Student findStudentByNameLike(String name);

  @Query("select s from Student s where s.id = :email")
  Student findStudentByEmail(String email);

  @Query("select s from Student s where s.id = :age")
  List<Student> findStudentByAge(String age);

  List<Student> findAll();

}
