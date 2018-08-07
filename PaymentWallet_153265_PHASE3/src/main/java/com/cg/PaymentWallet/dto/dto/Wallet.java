package com.cg.PaymentWallet.dto.dto;



import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;


@Embeddable
public class Wallet implements Serializable{
private BigDecimal balance;
private String password;
public Wallet(BigDecimal balance,String passowrd) {
	super();
	this.balance = balance;
	this.password=passowrd;
	
}
@Override
public String toString() {
	return "Wallet [balance=" + balance +"]";
}
public BigDecimal getBalance() {
	return balance;
}
public void setBalance(BigDecimal balance) {
	this.balance = balance;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public Wallet() {
	
	
}

}