package com.example.Schoolmanagementjpa.Services;

import com.example.Schoolmanagementjpa.Entites.Student;
import com.example.Schoolmanagementjpa.Exceptions.ApiException;
import com.example.Schoolmanagementjpa.Repositers.StudentRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    private  final StudentRepositry studentRepositry;

    public List<Student> getStudents() {
        return studentRepositry.findAll();
    }

    public void addstudents(Student student){
        studentRepositry.save(student);
    }

    public void updatestudent(Student student,Integer id){
        Student oldstudent= studentRepositry.getById(id);
        oldstudent.setName(student.getName());
        oldstudent.setAge(student.getAge());
        oldstudent.setMajor(student.getMajor());
        studentRepositry.save(student);
    }
   public Student getstudentbyid(String id){
    Student student= studentRepositry.findStudentById(id);
       if(student==null){
           throw new ApiException(("wrong id"));
       }
       return student;
   }
   public Student getstudentbyname(String name){
        Student student=studentRepositry.findStudentByName(name);
        if(student==null){
            throw new ApiException(("Student name invalid"));
        }
        return student;
   }

   public List<Student> getstudentsbymajor(String major){
        List<Student> students=studentRepositry.findAllByMajor(major);

       if(students==null){
           throw new ApiException(("major invalid"));
       }
       return students;
   }


    public List<Student> getstudentsgreaterthan(Integer age) {
        return  studentRepositry.findByAgeGreaterThan(age);

    }


    public void deletestudent(Integer id){
        Student student=studentRepositry.getById(id);
        studentRepositry.delete(student);
    }
}
