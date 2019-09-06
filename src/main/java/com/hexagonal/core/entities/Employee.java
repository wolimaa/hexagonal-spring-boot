package com.hexagonal.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	String name;

}
