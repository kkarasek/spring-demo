package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

//    @DeleteMapping("{studentId}")
//    public void deleteStudent(@PathVariable int studentId){      // path=student/{id}
    @DeleteMapping()
    public void deleteStudent(@RequestParam int studentId){    // path=student?studentId={id}
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/update/{studentId}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentId){
        studentService.updateStudent(student, studentId);
    }
}
