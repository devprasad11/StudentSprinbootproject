package com.codewithprasad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codewithprasad.entity.Student;
import com.codewithprasad.repository.StudengtRepository;

@RestController
public class Controller {
	
	@Autowired
	StudengtRepository repo;
	@GetMapping("/students")
	
	public List<Student> getAllStuden(){
		List<Student> Student=repo.findAll();
		return Student;
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student Student=repo.findById(id).get();
		
		return Student;
		
	}
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createstudent(@RequestBody Student Student) {
		repo.save(Student);
		
	}
	
	@PutMapping("/students/update/{id}")
	 public Student updateStudent(@PathVariable int id) {
		
	 Student Student=repo.findById(id).get();
	 Student.setName("Rushi");
	 Student.setBranch("mba");
	 Student.setPercentage(95);
	 repo.save(Student);
	 return Student;
	 
	
	}
	
	@DeleteMapping("/students/{id}")
	public void removeStudent(@PathVariable int id) {
		Student Student=repo.findById(id).get();
		repo.delete(Student);
	}
}

