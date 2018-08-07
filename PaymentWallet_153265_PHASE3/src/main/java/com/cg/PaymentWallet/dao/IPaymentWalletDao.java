package com.cg.PaymentWallet.dao;
import java.math.BigDecimal;

import com.cg.PaymentWallet.dto.dto.*;
import com.cg.PaymentWallet.exception.*;


public interface IPaymentWalletDao {
	com.cg.PaymentWallet.dto.dto.Customer registerCustomer(com.cg.PaymentWallet.dto.dto.Customer customer) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer depositMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer withdrawMoney(String phone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer fundTransfer(String sourcePhone,String targetPhone,BigDecimal balance) throws PaymentWalletException;
	com.cg.PaymentWallet.dto.dto.Customer showBalance(String phone) throws PaymentWalletException;
	String printTransaction(String phone) throws PaymentWalletException;
	boolean checkLogin(String number, String password);
	public abstract void commitTransaction();
	public abstract void beginTransaction();
}
