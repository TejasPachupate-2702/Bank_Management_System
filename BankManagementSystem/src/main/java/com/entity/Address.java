package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	private int house_number;
	private long pincode;
	private String state;
	private String city;
}
