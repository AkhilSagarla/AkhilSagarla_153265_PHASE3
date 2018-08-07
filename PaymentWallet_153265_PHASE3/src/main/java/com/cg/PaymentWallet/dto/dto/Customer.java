
package com.cg.PaymentWallet.dto.dto;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
@Entity
@Table(name="Paymentwallets")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)	
public class Customer implements Serializable{
@Id
private String phoneNumber;
private String emailId;
private String name;
private int Age;
private String Gender;

private String statement;
@Embedded
private Wallet wallet;
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStatement() {
	return statement;
}
public void setStatement(String statement) {
	this.statement = statement;
}
public Wallet getWallet() {
	return wallet;
}
public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}


@Override
public String toString() {
	return "Customer [phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", name=" + name + ", Age=" + Age
			+ ", Gender=" + Gender + ", statement=" + statement + ", wallet=" + wallet + "]";
}
public Customer(String phoneNumber, String emailId, String name, String statement, Wallet wallet) {
	super();
	this.phoneNumber = phoneNumber;
	this.emailId = emailId;
	this.name = name;
	this.statement = statement;
	this.wallet = wallet;
}
public Customer() {
	wallet = new Wallet();
}

}

