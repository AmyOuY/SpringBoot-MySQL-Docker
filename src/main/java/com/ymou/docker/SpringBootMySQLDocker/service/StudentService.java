package com.ymou.docker.SpringBootMySQLDocker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymou.docker.SpringBootMySQLDocker.model.Student;
import com.ymou.docker.SpringBootMySQLDocker.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}
	
	
	public List<Student> getAllStudents(){
		return repo.findAll();
	}
	
	
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	
	public Student updateStudent(Student student) {
		return repo.save(student);
	}
	
	
	public String deleteStudentById(int id) {
		repo.deleteById(id);
		return "Deleted student with Id: " + id;
	}
}
