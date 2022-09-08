package com.proj.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.proj.demo.model.Employee;
import com.proj.demo.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = new Employee();
		if(optional.isPresent()) {
			employee = optional.get();
		}
		else {
			throw new RuntimeException(" Employee Not Found!!");
		}
		return employee;
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	}

}
