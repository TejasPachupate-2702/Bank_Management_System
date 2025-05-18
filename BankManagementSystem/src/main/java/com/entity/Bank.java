package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "b_id")
	@SequenceGenerator(name = "b_id", initialValue = 101, allocationSize = 1)
	private int b_id;
	private String b_name;
	private String b_location;
	private String b_branch;

	@OneToMany
	private List<Customer> c;
}
