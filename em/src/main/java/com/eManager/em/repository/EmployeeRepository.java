package com.eManager.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eManager.em.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
