package com.eManager.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eManager.em.model.Employee;
import com.eManager.em.repository.EmployeeRepository;

/**
 * This is class ensures that the data 
 * is deleted and updated without 
 * causing any corruption in the unique datas 
 * @author jisanreza
 *
 */

@Service
@Transactional
public class EmployeeService {
	
	private final EmployeeRepository eRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	/**
	 * adds the employee
	 * @param employee
	 * @return
	 */
	public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return eRepo.save(employee);
    }
	
	/**
	 * updates the employee
	 * @param employee
	 * @return
	 */
	public Employee updateEmployee(Employee employee) {
		return eRepo.save(employee);
	}
	
	/**
	 * deletes the employee
	 * @param id
	 */
	public void deleteEmployee(Long id) {
		eRepo.deleteEmployeeById(id);
	}
}
