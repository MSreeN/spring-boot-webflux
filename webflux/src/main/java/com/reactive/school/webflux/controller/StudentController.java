package com.reactive.school.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.school.webflux.entity.Student;
import com.reactive.school.webflux.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {
  
  @Autowired
  private StudentService studentService;

  @PostMapping("/add")
  public Mono<Student> addStudent(@RequestBody Student student){
    return studentService.addStudent(student);
  }

  @PutMapping("/update/{studentId}")
  public Mono<Student> updateStudent(@RequestBody Student student, @PathVariable("studentId")String studentId){
    return studentService.updateStudent(student, studentId);
  }

  @GetMapping("/all")
  public Flux<Student> getAllStudents(){
    return studentService.getAllStudents();
  }

  // @GetMapping("/byBranch/{branchName}")
  // public Flux<Student> getByStudentBranch(@PathVariable("branchName")String branchName){
  //   // return studentService.getByBranchName(branchName);
  //   return studentService.getAllStudents();
  // }

  @GetMapping("/byBranch/{branchName}")
  public Flux<Student> getByBranchName(@PathVariable("branchName")String branchName){
    return studentService.getByBranchName(branchName);
  }
}
