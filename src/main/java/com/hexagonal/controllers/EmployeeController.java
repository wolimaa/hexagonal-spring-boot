package com.hexagonal.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.core.entities.Employee;
import com.hexagonal.core.services.IEmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@ApiOperation(value = "List all employees")
	@GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CompletableFuture<List<Employee>> get() {
		return employeeService.getAll();
	}

	@ApiOperation(value = "Get a employee by id")
	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CompletableFuture<Employee> getById(long id) {
		return employeeService.get(id);
	}

	@ApiOperation(value = "Create a new employee")
	@PostMapping(value = "/employee")
	public Employee post(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

}
