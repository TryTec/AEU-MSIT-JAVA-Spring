/**
 * 
 */
package com.example.demo.service;

/**
 * @author Try
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	// CREATE 
	public Employee createEmployee(Employee emp) {
	    return empRepository.save(emp);
	}

	// READ
	public List<Employee> getEmployees() {
	    return empRepository.findAll();
	}

	// DELETE
	public void deleteEmployee(Long id) {
	    empRepository.deleteById(id);
	}
	
	// UPDATE
	public Employee updateEmployee(Long id, Employee employeeDetails) {
	        Employee emp = empRepository.findById(id).get();
	        emp.setFirstName(employeeDetails.getFirstName());
	        emp.setLastName(employeeDetails.getLastName());
	        emp.setMobile(employeeDetails.getMobile());
	        emp.setEmail(employeeDetails.getEmail());
	        
	        return empRepository.save(emp);                                
	}

}