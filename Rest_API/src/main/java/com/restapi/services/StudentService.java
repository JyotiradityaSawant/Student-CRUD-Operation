package com.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.dao.StudentRepository;
import com.restapi.entities.Student;

@Component
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	

	//Selecting the data(all Students)
	public List<Student> getStudents() {
		List<Student> list = (List<Student>) studentRepository.findAll();
		return list;
	}

	//Selecting the data(Student) by using studentId
	public Student getStudentById(int id) {

		Student student = null;
		try {
			student = studentRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	

	// creating the data(student) based on user input
	public Student addStudent(Student student) {
		studentRepository.save(student);
		return student;
	}
	
	//Updating the data based using studentId
	public void updateStudent(int id,Student student) {
		
		student.setStudentId(id);
		studentRepository.save(student);
		
	}
	
	//Deleting the data(Student) by using studentId
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
