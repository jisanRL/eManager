package com.eManager.em.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eManager.em.model.Employee;
import com.eManager.em.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class eController {
	
	@Autowired
	private EmployeeRepository eRepo;
	
	/**
	 * get all the employees 
	 * @return
	 */
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return eRepo.findAll();
	}
	
	/**
	 * gets the employee by name
	 * @return
	 */
	@GetMapping("/get/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name) {
		try {
			List<Employee> emp = new ArrayList<>(eRepo.findByNameLike("%" + name + "%"));
			if (emp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * adds the the user to the database
	 */
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		// generate the random employee code
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return eRepo.save(employee);
	}
	
	/**
	 * Deletes user from the database
	 * @param id
	 * @return
	 */
	@DeleteMapping( path = { "/{id}" } )
	public Employee deleteEmployee(@PathVariable("id") long id) {
		Employee emp = eRepo.getOne(id);
		eRepo.deleteById(id);
		return emp;
	}
}
