package com.example.studentsmanager.service;

import com.example.studentsmanager.model.Student;
import com.example.studentsmanager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    public Student saveStudent(Student student){
        return repository.save(student);

//        test command
    }
    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
    public Student getStudentById(Long id){
        return repository.findById(id).orElse(null);
    }
}
