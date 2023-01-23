package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

// @Component
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll(); // returns list
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional =
        studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken.");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(int studentId){
        boolean isFound = studentRepository.existsById(studentId);
        if(!isFound){
            throw new IllegalStateException("Id: " + studentId + " cannot be found.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Student student, int studentId){
        boolean isFound = studentRepository.existsById(studentId);
        if(!isFound) {
//            this.addNewStudent(student);
            throw new IllegalStateException("No id found. Cannot update the student.");
        }
        studentRepository.findById(studentId).map((element) -> {
            element.setName(student.getName());
            element.setEmail(student.getEmail());
            return studentRepository.save(element);
        });

    }
}
