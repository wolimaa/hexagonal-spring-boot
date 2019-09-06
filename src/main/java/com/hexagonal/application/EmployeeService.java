package com.hexagonal.application;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hexagonal.core.entities.Employee;
import com.hexagonal.core.repositories.IEmployeeRepository;
import com.hexagonal.core.services.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	@Override
	@Async("asyncExecutor")
	public CompletableFuture<List<Employee>> getAll() {
		return CompletableFuture.supplyAsync(() -> this.employeeRepository.findAllEmployees());
	}

	@Override
	public CompletableFuture<Employee> get(long id) {
		return CompletableFuture.supplyAsync(() -> this.employeeRepository.findEmployee(id));
	}

	@Override
	public Employee save(Employee employee) {
		this.employeeRepository.save(employee);
		return employee;
	}

}
