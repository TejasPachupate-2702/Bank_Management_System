package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.entity.Account;
import com.entity.Address;
import com.entity.Customer;
import com.util.DBConnections;

public class AddressDAO {

	public static void addAddress(Address add) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(add);
		et.commit();
	}

	public static void findAllAddress() {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select a from Address a";
		et.begin();
		Query q = em.createQuery(jqql);
		List<Customer> li = q.getResultList();
		li.forEach(al -> System.out.println(al));
		et.commit();
	}

	public static void findByHouseNumber(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "select a from Address a where a.house_number=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		Customer c = (Customer) q.getSingleResult();
		System.out.println(c);
		et.commit();
	}

	public static void deleteByHouseNumber(int id) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "delete from Address a where a.house_number=?1";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, id);
		q.executeUpdate();
		et.commit();
	}
	
	public static void updatePincode(int pin , int hs) {
		EntityManager em = DBConnections.getConnection();
		EntityTransaction et = em.getTransaction();
		String jqql = "update Address a set a.pincode = ?1 where a.house_number=?2";
		et.begin();
		Query q = em.createQuery(jqql);
		q.setParameter(1, pin);
		q.setParameter(2, hs);
		q.executeUpdate();
		et.commit();
	}

}
