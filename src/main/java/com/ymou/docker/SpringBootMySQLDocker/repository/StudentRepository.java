package com.ymou.docker.SpringBootMySQLDocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ymou.docker.SpringBootMySQLDocker.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
