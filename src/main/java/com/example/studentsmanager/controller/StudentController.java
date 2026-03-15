package com.example.studentsmanager.controller;

import com.example.studentsmanager.model.Student;
import com.example.studentsmanager.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @GetMapping
    public String getStudents(Model model){
        model.addAttribute("students",service.getAllStudents());
        return "students";
    }
    @PostMapping("/save")
    public String addStudent(Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){

        Student student = service.getStudentById(id);

        model.addAttribute("student", student);

        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(Student student){

        service.saveStudent(student);

        return "redirect:/students";
    }
    @GetMapping("/add")
    public String showAddForm(Model model){

        model.addAttribute("student", new Student());

        return "add-student";
    }
}
