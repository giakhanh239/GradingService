package com.example.GradingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GradingService.entity.Student;
@Repository
public interface StudentRepository extends  JpaRepository<Student,Integer>{

}
