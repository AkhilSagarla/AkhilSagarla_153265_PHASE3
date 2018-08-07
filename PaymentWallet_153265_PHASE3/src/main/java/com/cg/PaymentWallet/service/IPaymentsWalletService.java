package com.cg.PaymentWallet.service;
import java.math.BigDecimal;

import com.cg.PaymentWallet.dto.dto.Wallet;
import com.cg.PaymentWallet.exception.PaymentWalletException;


public interface IPaymentsWalletService {
	
	com.cg.PaymentWallet.dto.dto.Customer registerCustomer(com.cg.PaymentWallet.dto.dto.Customer customer)throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer depositMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer withdrawMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer showBalance(String phone) throws PaymentWalletException;
	String printTransaction(String phone) throws PaymentWalletException;
	boolean validatePhone(String phoneNumber) throws PaymentWalletException;
	boolean validateMoney(BigDecimal balance) throws PaymentWalletException;
	boolean validateAge(Integer age) throws PaymentWalletException;
	boolean validateGender(String gender) throws PaymentWalletException;
	boolean validateName(String name) throws PaymentWalletException;
	boolean validateEmail(String emailId) throws PaymentWalletException;
	boolean validatePassword(String pass)throws PaymentWalletException;
	boolean checkLogin(String number, String password);
	
}
