package com.example.Schoolmanagementjpa.Controllers;
import com.example.Schoolmanagementjpa.Entites.Teacher;
import com.example.Schoolmanagementjpa.Services.TeacherService;
import com.example.Schoolmanagementjpa.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/teach")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity Getteachers(){
        List<Teacher> teachers=teacherService.getteacher();
        return  ResponseEntity.status(201).body(teachers);
    }
    @GetMapping("/id")
    public ResponseEntity<Teacher> GetteacherById(@PathVariable String id){
       Teacher teacher=teacherService.getteacherbyid(id);
        return  ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/salary")
    public ResponseEntity<List<Teacher>> Getteacherbysalary(@PathVariable Integer salary){
        List <Teacher> teachers=teacherService.getteachersgreaterthan(salary);
        return  ResponseEntity.status(200).body(teachers);
    }
    @PostMapping
    public ResponseEntity Addteacher(@RequestBody @Valid Teacher teacher){
        teacherService.addteacher(teacher);
        return  ResponseEntity.status(200).body(new ApiResponse("teacher added!",200));
    }

    @PutMapping("/{id}")
    public ResponseEntity Updatestudent(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherService.updateteacher(teacher,id);
        return  ResponseEntity.status(200).body(new ApiResponse("teacher updated!",200));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteteacher(@PathVariable Integer id){
        teacherService.deleteteacher(id);
        return  ResponseEntity.status(200).body(new ApiResponse("teacher deleted!",200));
    }
}
