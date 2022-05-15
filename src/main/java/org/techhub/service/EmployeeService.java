package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.entity.Employee;
import org.techhub.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public Employee adNewEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	public List<Employee> getAllDetails() {
		return employeeRepo.findAll();
	}

	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepo.findById(id);
	}

	public int updateEmployee(int id, String name, String address) {
		return employeeRepo.updateEmployee(id, name, address);
	}

	public void deletedById(int id) {
		 employeeRepo.deleteById(id);
		 
	}

}
