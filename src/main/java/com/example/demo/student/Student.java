package com.example.demo.student;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private int id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    @Transient
    private int age;


    public Student() {
    }

    public Student(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Student(int id, String name, String email, LocalDate dataOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dataOfBirth;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge()
    {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
