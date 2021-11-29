package com.ymou.docker.SpringBootMySQLDocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymou.docker.SpringBootMySQLDocker.model.Student;
import com.ymou.docker.SpringBootMySQLDocker.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student studentAdded = service.addStudent(student);
		return new ResponseEntity<Student>(studentAdded, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = service.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Student student = service.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Student> updataStudent(@RequestBody Student student){
		service.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){		
		String message = service.deleteStudentById(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
