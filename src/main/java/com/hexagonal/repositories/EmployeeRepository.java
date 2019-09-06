package com.hexagonal.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.hexagonal.core.entities.Employee;
import com.hexagonal.core.repositories.IEmployeeRepository;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> findAllEmployees() {

		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> variableRoot = query.from(Employee.class);
		query.select(variableRoot);
		return this.entityManager.createQuery(query).getResultList();

	};

	@Override
	public Employee findEmployee(long id) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> c = query.from(Employee.class);
		query.select(c);
		query.where(criteriaBuilder.gt(c.get("id"), id));
		return this.entityManager.createQuery(query).getResultList().get(0);

	}

	@Override
	public void save(Employee entity) {
				
		this.entityManager.getTransaction().begin();		
		this.entityManager.persist(entity);
		this.entityManager.getTransaction().commit();

	}

}
