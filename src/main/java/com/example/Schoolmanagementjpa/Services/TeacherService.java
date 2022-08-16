package com.example.Schoolmanagementjpa.Services;
import com.example.Schoolmanagementjpa.Entites.Teacher;
import com.example.Schoolmanagementjpa.Exceptions.ApiException;
import com.example.Schoolmanagementjpa.Repositers.TeacherRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private  final TeacherRepositry teacherRepositry;

    public List<Teacher> getteacher() {
        return teacherRepositry.findAll();
    }

    public Teacher getteacherbyid(String id){
        Teacher teacher=teacherRepositry.findTeacherById(id);
        if(teacher==null){
            throw new ApiException(("wrong id"));
        }
        return teacher;
    }
    public List<Teacher> getteachersgreaterthan(Integer salary){
      return teacherRepositry.findBySalaryGreaterThan(salary);

    }


    public void addteacher(Teacher teacher){
        teacherRepositry.save(teacher);
    }

    public void updateteacher(Teacher teacher,Integer id){
       Teacher oldteacher= teacherRepositry.getById(id);
       oldteacher.setName(teacher.getName());
      oldteacher.setSalary(teacher.getSalary());
      teacherRepositry.save(teacher);
    }

    public void deleteteacher(Integer id){
       Teacher teacher=teacherRepositry.getById(id);
       teacherRepositry.delete(teacher);
    }
}
