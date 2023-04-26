package com.reactive.school.webflux.utils;

import org.springframework.beans.BeanUtils;

import com.reactive.school.webflux.dto.StudentDto;
import com.reactive.school.webflux.entity.Student;

public class AppUtils {
  

  public static StudentDto entityToDto(Student student){
    StudentDto studentDto = new StudentDto();
    BeanUtils.copyProperties(student, studentDto);
    return studentDto;
  }

  public static Student dtoToEntity(StudentDto studentDto){
    Student student = new Student();
    BeanUtils.copyProperties(studentDto, student);
    return student;
  }
}
