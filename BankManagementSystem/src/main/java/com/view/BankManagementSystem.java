package com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.AccountDAO;
import com.dao.AddressDAO;
import com.dao.BankDAO;
import com.dao.CustomerDAO;
import com.entity.Account;
import com.entity.Address;
import com.entity.Bank;
import com.entity.Customer;

public class BankManagementSystem {

	public static void main(String[] args) {
		Account a = new Account();
		a.setAcc_no(1235);
		a.setBalance(90000);
		a.setCredit_score(500.78);

		Address add = new Address();
		add.setHouse_number(202);
		add.setPincode(4151125);
		add.setState("MH");
		add.setCity("Pune");

		Customer c = new Customer();
		c.setC_name("Shubham");
		c.setC_dob("27-12-2222");
		c.setC_phone(9876543212L);
		c.setA(a);
		c.setAdd(add);

		Customer c1 = new Customer();
		c1.setC_name("Raj");
		c1.setC_dob("27-12-2222");
		c1.setC_phone(9876543212L);
		c1.setA(a);
		c1.setAdd(add);

		List<Customer> li = new ArrayList();
		li.add(c);
		li.add(c1);

		Bank b = new Bank();
		b.setB_branch("Wakad");
		b.setB_location("Pune");
		b.setB_name("ICICI");
		b.setC(li);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Wel-Come to Our Bank");
		System.out.println("Enter A for create new Bank Account");
		System.out.println("Enter B for performing manupulation on Bank Details");
		System.out.println("Enter C for performing manupulation on Customer Details");
		System.out.println("Enter D for performing manupulation on Account Details");
		System.out.println("Enter E for performing manupulation on Address Details");
		
		char choice = s.next().charAt(0);
		switch(choice)
		{
		case 'A' :{
			BankDAO.createNewAccount(b,c,a,add);
			break;
		}
		case 'B' :{
			System.out.println("Enter 1 for add bank details");
			System.out.println("Enter 2 for find all bank details");
			System.out.println("Enter 3 for find bank by Bank Id");
			System.out.println("Enter 4 for Delete bank by bank Id");
			System.out.println("Enter 5 for De-Allocate Customer ");
			System.out.println("Enter 6 for Allocate Customer ");
			int choice1 = s.nextInt();
			switch(choice1) {
			case 1 : {
				BankDAO.addBank(b);
				break;
			}
			case 2 : {
				BankDAO.findAllBank();;
				break;
			}
			case 3 : {
				System.out.println("Enter Bank id");
				int id = s.nextInt();
				BankDAO.findBankById(id);;
				break;
			}
			case 4 : {
				System.out.println("Enter Bank id");
				int id = s.nextInt();
				BankDAO.deleteBankById(id);;
				break;
			}
			case 5 : {
				System.out.println("Enter Bank id");
				int id = s.nextInt();
				BankDAO.deAllocateCustomer(id);;
				break;
			}
			case 6 : {
				System.out.println("Enter Bank id");
				int id = s.nextInt();
				System.out.println("Enter Customer id");
				int cid = s.nextInt();
				BankDAO.allocateCustomer(cid,id);;
				break;
			}
			}
			
		}
		case 'C' :{
			System.out.println("Enter 1 for add Customer details");
			System.out.println("Enter 2 for find all Customer details");
			System.out.println("Enter 3 for find Customer by customer Id");
			System.out.println("Enter 4 for Delete customer by customer Id");
			System.out.println("Enter 5 for De-Allocate AccountNo ");
			System.out.println("Enter 6 for Allocate AccountNo ");
			int choice2 = s.nextInt();
			switch(choice2) {
			case 1 : {
				CustomerDAO.addCustomer(c);
			}
			case 2 : {
				CustomerDAO.findAllCustomer();
				break;
			}
			case 3 : {
				System.out.println("Enter Customer id");
				int id = s.nextInt();
				CustomerDAO.findById(id);
				break;
			}
			case 4 : {
				System.out.println("Enter Customer id");
				int id = s.nextInt();
				CustomerDAO.deleteById(id);
				break;
			}
			case 5 : {
				System.out.println("Enter customer id");
				int id = s.nextInt();
				CustomerDAO.deAllocateAccountNumber(id);
				break;
			}
			case 6 : {
				System.out.println("Enter Customer id");
				int id = s.nextInt();
				System.out.println("Enter Account No");
				int acc = s.nextInt();
				BankDAO.allocateCustomer(acc, id);;
				break;
			}
			}
		}
		case 'D' :{
			System.out.println("Enter 1 for add Account details");
			System.out.println("Enter 2 for find all Account details");
			System.out.println("Enter 3 for find bank Account by Account No");
			System.out.println("Enter 4 for Delete Account by Account No");
			System.out.println("Enter 5 for Update Credit Score ");
			int choice3 = s.nextInt();
			switch(choice3) {
			case 1 : {
				AccountDAO.addAccount(a);
				break;
			}
			case 2 : {
				AccountDAO.findAllAccount();
				break;
			}
			case 3 : {
				System.out.println("Enter Account No");
				int acc = s.nextInt();
				AccountDAO.findByAccountNumber(acc);
				break;
			}
			case 4 : {
				System.out.println("Enter Account no");
				int acc = s.nextInt();
				AccountDAO.deleteDetailsByAccountNumber(acc);
				break;
			}
			case 5 : {
				System.out.println("Enter Credit score");
				double cs = s.nextDouble();
				System.out.println("Enter Account no");
				int acc = s.nextInt();
				AccountDAO.updateCreditScore(cs, acc);
				break;
			}
			}
		}
		case 'E' :{
			System.out.println("Enter 1 for add Address details");
			System.out.println("Enter 2 for find all Address details");
			System.out.println("Enter 3 for find Address by house Number");
			System.out.println("Enter 4 for Delete Address by house Number");
			System.out.println("Enter 5 for Update pincode  ");
			
			int choice1 = s.nextInt();
			switch(choice1) {
			case 1 : {
				AddressDAO.addAddress(add);
				break;
			}
			case 2 : {
				AddressDAO.findAllAddress();
				break;
			}
			case 3 : {
				System.out.println("Enter House no");
				int h = s.nextInt();
				AddressDAO.findByHouseNumber(h);
				break;
			}
			case 4 : {
				System.out.println("Enter house no");
				int h = s.nextInt();
				AddressDAO.deleteByHouseNumber(h);
				break;
			}
		
			case 5 : {
				System.out.println("Enter pincode");
				int pin = s.nextInt();
				System.out.println("Enter house no");
				int hs = s.nextInt();
				AddressDAO.updatePincode(pin, hs);
				break;
			}
			}
		}
	  }
	}
}
