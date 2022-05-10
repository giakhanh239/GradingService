package com.example.GradingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GradingService.entity.Student;
@Repository
public interface BaseRepository extends JpaRepository<Student, Long> {
	List<Student> findAll ();
}
