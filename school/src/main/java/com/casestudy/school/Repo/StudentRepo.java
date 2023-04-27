package com.casestudy.school.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.school.Model.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

  Optional<Student> findByStudentName(String studentName);

}
