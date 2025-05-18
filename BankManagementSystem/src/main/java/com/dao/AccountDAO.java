package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Account;
import com.entity.Address;
import com.entity.Bank;
import com.entity.Customer;
import com.util.DBConnections;

public class AccountDAO {

	public static void addAccount(Account a) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
	}

	public static void findAllAccount() {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select a from Account a";
		et.begin();
		Query q = em.createQuery(jqql);
		List<Customer> li = q.getResultList();
		li.forEach(al -> System.out.println(al));
		et.commit();
	}

	public static void findByAccountNumber(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select a from Account a where a.acc_no=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		Customer c = (Customer) q.getSingleResult();
		System.out.println(c);
		et.commit();
	}

	public static void deleteDetailsByAccountNumber(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "delete from Account a where a.acc_no=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		q.executeUpdate();
		et.commit();
	}
	
	public static void updateCreditScore(double cs , int acc_no) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "update Account a set credit_score = ?1 where acc_no=?2";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, cs);
		q.setParameter(2, acc_no);
		q.executeUpdate();
		et.commit();
	}
}
