package com.example.Schoolmanagementjpa.Repositers;
import com.example.Schoolmanagementjpa.Entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositry extends JpaRepository<Student,Integer> {


    Student findStudentById(String id);
    Student findStudentByName(String name);
    List<Student> findAllByMajor(String major);
    List<Student> findByAgeGreaterThan(Integer age);




}
