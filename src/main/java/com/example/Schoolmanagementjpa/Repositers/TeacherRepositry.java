package com.example.Schoolmanagementjpa.Repositers;

import com.example.Schoolmanagementjpa.Entites.Student;
import com.example.Schoolmanagementjpa.Entites.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(String id);
    List<Teacher> findBySalaryGreaterThan(Integer salary);
}
