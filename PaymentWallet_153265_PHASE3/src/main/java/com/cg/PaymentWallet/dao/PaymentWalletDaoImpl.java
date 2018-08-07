package com.cg.PaymentWallet.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.PaymentWallet.dto.dto.*;
import com.cg.PaymentWallet.exception.PaymentWalletException;


public class PaymentWalletDaoImpl implements IPaymentWalletDao{

	private EntityManager entityManager;

	public PaymentWalletDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	/*public Customer registerCustomer(Customer wallet)
			throws PaymentWalletException {
		entityManager.persist(wallet);
		return wallet;
	}*/

	public Customer depositMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			BigDecimal update=wall.getWallet().getBalance().add(balance);
			wall.getWallet().setBalance(update);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have deposited "+balance+" on "+LocalDateTime.now()+" stat" );
			wall.setStatement(add);
			entityManager.merge(wall);
		}
		
		return wall;
	}

	public Customer withdrawMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			if(wall.getWallet().getBalance().compareTo(BigDecimal.valueOf(1000))>=0)
			{
			BigDecimal m=wall.getWallet().getBalance().subtract(balance);
			wall.getWallet().setBalance(m);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have withdrawed "+balance+" on "+LocalDateTime.now()+" stat" );
			wall.setStatement(add);
			entityManager.merge(wall);
			}
			
		}
		return wall;
	}

	public Customer fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,sourcePhone);
		if(wall!=null)
		{
			if(wall.getWallet().getBalance().compareTo(BigDecimal.valueOf(1000))>=0){
			BigDecimal m=wall.getWallet().getBalance().subtract(balance);
			wall.getWallet().setBalance(m);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have funded "+balance+" on "+LocalDateTime.now()+" stat" );
			wall.setStatement(add);
			entityManager.merge(wall);
	        }
		}
		
		Customer wall1 = entityManager.find(Customer.class,targetPhone);
		if(wall1!=null)
		{
			BigDecimal update=wall1.getWallet().getBalance().add(balance);
			wall.getWallet().setBalance(update);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have got funded "+balance+" on "+LocalDateTime.now()+" stat" );
			wall.setStatement(add);
			entityManager.merge(wall1);
		}
		return wall;
	}

	public Customer showBalance(String phone) throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			return wall;
		}
		return wall;
	}

	public String printTransaction(String phone) throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		String statement=null;
		if(wall!=null)
		{
			statement=wall.getStatement();
		}
		return statement;
	}

	public boolean checkLogin(String number, String password) {
		Customer wall = entityManager.find(Customer.class,number);
		if(wall!=null)
		{
			if((wall.getPhoneNumber().equals(number))&&(wall.getWallet().getPassword().equals(password)))
			{
				
				return true;
			}
		}
			return false;
	}

	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}



	public Customer registerCustomer(Customer customer) throws PaymentWalletException {
		entityManager.persist(customer);
		return customer;
	}

	

	
	
/*
	public String printTransaction(String phone) throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		String statement=null;
		if(wall!=null)
		{
			statement=wall.getStatement();
		}
		return statement;
	}

	public boolean checkLogin(String number, String password) {
	
	Customer wall = entityManager.find(Customer.class,number);
	if(wall!=null)
	{
		if((wall.getPhoneNumber().equals(number))&&(wall.getWallet().getPassword().equals(password)))
		{
			
			return true;
		}
	}
		return false;
	}

	public void commitTransaction() {
		
		entityManager.getTransaction().commit();
	}

	public void beginTransaction() {

		entityManager.getTransaction().begin();
	}


	public com.cg.paymentwallet.dto.Customer registerCustomer(com.cg.paymentwallet.dto.Customer wallet)
			throws PaymentWalletException {
		entityManager.persist(wallet);
		return wallet;
	}


	public com.cg.paymentwallet.dto.Customer depositMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			BigDecimal update=wall.getWallet().getBalance().add(balance);
			wall.getWallet().setBalance(update);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have deposited "+balance+" on "+LocalDateTime.now()+" zzz" );
			wall.setStatement(add);
			entityManager.merge(wall);
		}
		
		return wall;
	}


	public com.cg.paymentwallet.dto.Customer withdrawMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		// TODO Auto-generated method stub
		return null;
	}


	public com.cg.paymentwallet.dto.Customer fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance)
			throws PaymentWalletException {
		// TODO Auto-generated method stub
		return null;
	}


	public com.cg.paymentwallet.dto.Customer showBalance(String phone) throws PaymentWalletException {
		// TODO Auto-generated method stub
		return null;
	}*/


	/*public Customer depositMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			BigDecimal update=wall.getWallet().getBalance().add(balance);
			wall.getWallet().setBalance(update);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have deposited "+balance+" on "+LocalDateTime.now()+" zzz" );
			wall.setStatement(add);
			entityManager.merge(wall);
		}
		
		return wall;
		
	}


	public Customer withdrawMoney(String phone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			if(wall.getWallet().getBalance().compareTo(BigDecimal.valueOf(1000))>=0)
			{
			BigDecimal m=wall.getWallet().getBalance().subtract(balance);
			wall.getWallet().setBalance(m);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have withdrawed "+balance+" on "+LocalDateTime.now()+" zzz" );
			wall.setStatement(add);
			entityManager.merge(wall);
			}
			
		}
		return wall;
		
	}


	public Customer fundTransfer(String sourcePhone, String targetPhone, BigDecimal balance)
			throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,sourcePhone);
		if(wall!=null)
		{
			if(wall.getWallet().getBalance().compareTo(BigDecimal.valueOf(1000))>=0){
			BigDecimal m=wall.getWallet().getBalance().subtract(balance);
			wall.getWallet().setBalance(m);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have funded "+balance+" on "+LocalDateTime.now()+" zzz" );
			wall.setStatement(add);
			entityManager.merge(wall);
	        }
		}
		
		Customer wall1 = entityManager.find(Customer.class,targetPhone);
		if(wall1!=null)
		{
			BigDecimal update=wall1.getWallet().getBalance().add(balance);
			wall.getWallet().setBalance(update);
			String deposit=wall.getStatement();
			String add=deposit.concat("you have got funded "+balance+" on "+LocalDateTime.now()+" zzz" );
			wall.setStatement(add);
			entityManager.merge(wall1);
		}
		return wall;
	}


	public Customer showBalance(String phone) throws PaymentWalletException {
		Customer wall = entityManager.find(Customer.class,phone);
		if(wall!=null)
		{
			return wall;
		}
		return wall;
		
	}
*/
}