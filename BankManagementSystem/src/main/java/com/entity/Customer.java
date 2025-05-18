package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private String c_name;
	private String c_dob;
	private long c_phone;
	
	@OneToOne
	private Account a;
	
	@OneToOne
	private Address add;
}
