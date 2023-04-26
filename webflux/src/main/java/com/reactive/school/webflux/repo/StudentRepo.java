package com.reactive.school.webflux.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.reactive.school.webflux.entity.Student;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
  
}
