package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.entities.Student;
import com.restapi.services.StudentService;

@RestController
public class MainController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> list = studentService.getStudents();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
		Student student = studentService.getStudentById(id);
		if(student == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} return ResponseEntity.of(Optional.of(student));
	}
	

	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student st = null;
		try {
			st = studentService.addStudent(student);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
		try {
			this.studentService.updateStudent(studentId, student);
			return ResponseEntity.ok().body(student);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") int studentId){
		try {
			this.studentService.deleteStudent(studentId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
