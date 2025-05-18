package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Account;
import com.entity.Address;
import com.entity.Bank;
import com.entity.Customer;
import com.util.DBConnections;

public class CustomerDAO {

	public static void addCustomer(Customer c) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
	}

	public static void findAllCustomer() {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select c from Customer c";
		et.begin();
		Query q = em.createQuery(jqql);
		List<Customer> li = q.getResultList();
		li.forEach(al -> System.out.println(al));
		et.commit();
	}

	public static void findById(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select c from Customer c where c.c_id=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		Customer c = (Customer) q.getSingleResult();
		System.out.println(c);
		et.commit();
	}

	public static void deleteById(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "delete from Customer c where c.c_id=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		q.executeUpdate();
		et.commit();
	}

	public static void deAllocateAccountNumber(int c_id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String sql = "update Customer c set c.a = :acc_no where c_id = :c_id";
		et.begin();
		Query q = em.createQuery(sql);
		q.setParameter("acc_no", null);
		q.setParameter("c_id", c_id);
		q.executeUpdate();
		et.commit();
	}

	public static void allocateAccountNumber(int acc_no, int c_id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String sql = "update Customer c set c.a.acc_no = :acc_no where c_id = :c_id";
		et.begin();
		Query q = em.createQuery(sql);
		q.setParameter("acc_no", acc_no);
		q.setParameter("c_id", c_id);
		q.executeUpdate();
		et.commit();
	}

}
