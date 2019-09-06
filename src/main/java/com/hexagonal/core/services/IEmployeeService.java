package com.hexagonal.core.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hexagonal.core.entities.Employee;

public interface IEmployeeService {

	public CompletableFuture<List<Employee>> getAll();

	CompletableFuture<Employee> get(long id);

	Employee save(Employee employee);

}
