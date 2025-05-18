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

public class BankDAO {

	public static void addBank(Bank b) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(b);
		et.commit();
	}
	
	public static void createNewAccount(Bank b,Customer c ,Account a ,Address add) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(b);
		em.persist(c);
		em.persist(a);
		em.persist(add);
		et.commit();
	}

	public static void findAllBank() {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select b from Bank b";
		et.begin();
		Query q = em.createQuery(jqql);
		List<Customer> li = q.getResultList();
		li.forEach(al -> System.out.println(al));
		et.commit();
	}

	public static void findBankById(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select b from Bank b where b.b_id=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		Bank b1 = (Bank) q.getSingleResult();
		System.out.println(b1);
		et.commit();
	}

	public static void deleteBankById(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "delete from Bank b where b.b_id=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		q.executeUpdate();
		et.commit();
	}

	public static void deAllocateCustomer(int b_id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String sql = "update Bank b set b.c = :cid where b_id = :b_id";
		et.begin();
		Query q = em.createQuery(sql);
		q.setParameter("cid", null);
		q.setParameter("b_id", b_id);
		q.executeUpdate();
		et.commit();
	}

	public static void allocateCustomer(int cid, int bid ) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String sql = "update Bank b set b.c = :cid where b_id = :b_id";
		et.begin();
		Query q = em.createQuery(sql);
		q.setParameter("cid", cid);
		q.setParameter("b_id", bid);
		q.executeUpdate();
		et.commit();
	}
}
