package com.hexagonal.core.repositories;

import java.util.List;

import com.hexagonal.core.entities.Employee;

public interface IEmployeeRepository {

	List<Employee> findAllEmployees();

	Employee findEmployee(long id);

	void save(Employee entity);

}
