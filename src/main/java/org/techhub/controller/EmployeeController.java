package org.techhub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.entity.Employee;
import org.techhub.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/add")
	public String addNewEmployee(@RequestBody Employee employee) {
		Employee emp = empService.adNewEmployee(employee);
		if(emp!=null) {
			return "Data Save successfully...";
		}
		else {
			return "Some problem";
		}
	}

	@GetMapping("/view")
	public List<Employee> getAllDetails() {
		List<Employee> employeeList = empService.getAllDetails();
		return employeeList;
	}

	@GetMapping("/id/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable int id) {
		Optional<Employee> employeeList = empService.findEmployeeById(id);
		return employeeList;
	}

	@PutMapping("/update/{id}/{name}/{address}")
	public String updateEmployee(@PathVariable("id") int id, @PathVariable("name") String name,
			@PathVariable("address") String address) {
		int result = empService.updateEmployee(id,name,address);
		if(result>0) {
			return "Employee updated successfully....";
		}
		else {
			return "Some problem";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletedById(@PathVariable int id) {
		empService.deletedById(id);
	
	}
	
}
