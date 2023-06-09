package com.reactive.school.webflux.service;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.school.webflux.entity.Student;
import com.reactive.school.webflux.repo.StudentRepo;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {
  
  @Autowired
  private StudentRepo studentRepo;

  // public Flux<StudentDto> getAllStudents(){
  //   return studentRepo.findAll().map(AppUtils::entityToDto);
  // }

  // public Mono<StudentDto> addStudent(Mono<StudentDto> studentDto){
  //   return studentDto.map(AppUtils::dtoToEntity).flatMap(studentRepo::save).map(AppUtils::entityToDto);
  // }

  // public Flux<StudentDto> updateStudent(StudentDto studentDto, String id){

  // }

  public Flux<Student> getAllStudents(){
    return studentRepo.findAll();
  }

  public  Mono<Student> addStudent(Student student){
    return studentRepo.save(student);
  }

  public Mono<Student> updateStudent(Student student, String id){
    return studentRepo.findById(id)
    .map(s -> {
      s.setStudentName(student.getStudentName());
      s.setStudentBranch(student.getStudentBranch());
      return s;
    }).flatMap(s -> studentRepo.save(s));
  }

  public Flux<Student> getByBranchName(String branchName){
    Flux<Student> students = studentRepo.findAll();
    return students
    .filter(student -> student.getStudentBranch().equals(branchName));
    // return students;
  }


}
