package com.example.student_api_testing.Controller;

import com.example.student_api_testing.model.ExternalPost;
import com.example.student_api_testing.model.Student;
import com.example.student_api_testing.service.StudentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public record StudentRequest(
        @NotBlank String name,
        @NotBlank @Email String email
    ) {}
    
    @PostMapping("/students")
    @ResponseStatus (HttpStatus.CREATED)
    public Student addStudent (
    		@Valid @RequestBody StudentRequest request) {
    	return studentService.addStudent (
    			request.name(), request.email());
    }
    
    @GetMapping("/students")
    public List<Student> getAllStudents() {
    	return studentService.getAllStudents();
    }
    
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
    	return studentService.getStudentById(id);
    }
    
    @GetMapping("/external-posts")
    public List<ExternalPost> getExternalPosts() {
    	return studentService.getExternalPosts();
    }
}