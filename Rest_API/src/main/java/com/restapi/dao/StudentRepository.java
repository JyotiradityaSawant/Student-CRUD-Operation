package com.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public Student findById(int id);
	

}
