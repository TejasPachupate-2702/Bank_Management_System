package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	private int acc_no;
	private double balance;
	private double credit_score;

}
