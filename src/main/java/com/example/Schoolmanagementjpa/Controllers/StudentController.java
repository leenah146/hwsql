package com.example.Schoolmanagementjpa.Controllers;
import com.example.Schoolmanagementjpa.Entites.Student;
import com.example.Schoolmanagementjpa.Services.StudentService;
import com.example.Schoolmanagementjpa.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/stu")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity Getstudents(){
        List<Student> students=studentService.getStudents();
        return  ResponseEntity.status(201).body(students);
    }
    @GetMapping("/id")
    public ResponseEntity<Student> GetstudentById(@PathVariable String id){
        Student student=studentService.getstudentbyid(id);
        return  ResponseEntity.status(200).body(student);
    }

    @GetMapping("/name")
    public ResponseEntity<Student> GetstudentByName(@PathVariable String name){
        Student student=studentService.getstudentbyname(name);
        return  ResponseEntity.status(200).body(student);
    }
    @GetMapping("/age")
    public ResponseEntity<List<Student>> GetstudentByAge(@PathVariable Integer age){
       List <Student> students=studentService.getstudentsgreaterthan(age);
        return  ResponseEntity.status(200).body(students);
    }
    @GetMapping("/major")
    public ResponseEntity<List<Student>> GetstudentByMajor(@PathVariable String major){
        List <Student> students=studentService.getstudentsbymajor(major);
        return  ResponseEntity.status(200).body(students);
    }

    @PostMapping
    public ResponseEntity Addstudents(@RequestBody @Valid Student student){
        studentService.addstudents(student);
        return  ResponseEntity.status(200).body(new ApiResponse("student added!",200));
    }

    @PutMapping("/{id}")
    public ResponseEntity Updatestudent(@RequestBody @Valid Student student,@PathVariable Integer id){
        studentService.updatestudent(student, id);
        return  ResponseEntity.status(200).body(new ApiResponse("student updated!",200));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteuser(@PathVariable Integer id){
        studentService.deletestudent(id);
        return  ResponseEntity.status(200).body(new ApiResponse("student deleted!",200));
    }

}
