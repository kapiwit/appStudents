package com.example.appstudents.controller;

import com.example.appstudents.model.Student;
import com.example.appstudents.repository.StudentRepository;
import com.example.appstudents.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public String getStudentList(Model model){
        List<Student> studentList = studentService.getStudents();
        model.addAttribute("student", studentList);
        return "persons/personList";
    }
    @GetMapping("/addStudent")
    public String getAddStudent(){
        return "persons/addNewPerson";
    }
    @PostMapping("/addStudent")
    public RedirectView postAddStudent(Student student){
        studentService.addStudent(student);
        return new RedirectView("/students");
    }
    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model){
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "persons/editPerson";
    }


}
