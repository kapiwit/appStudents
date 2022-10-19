package com.example.appstudents.service;

import com.example.appstudents.model.Student;
import com.example.appstudents.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
    public Student getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
