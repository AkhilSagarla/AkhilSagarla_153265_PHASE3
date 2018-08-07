
package com.cg.PaymentWallet.ui;
import java.math.BigDecimal;
import java.util.Scanner;

import com.cg.PaymentWallet.dto.dto.Wallet;
import com.cg.PaymentWallet.exception.PaymentWalletException;
import com.cg.PaymentWallet.service.IPaymentsWalletService;
import com.cg.PaymentWallet.service.PaymentWalletServiceImpl;


import com.cg.PaymentWallet.dto.dto.*;
public class MainUI {
	public static void main(String args[])
	{
    	details();
  
}
    private static void details()
    { 
    IPaymentsWalletService paymentwalletservice=new PaymentWalletServiceImpl();
	int choice = 0;
	boolean valid = false;
	String money;
	String ch;
	String number;
while(true){
System.out.println("1. Register - for New user");
System.out.println("2.Login - If exsisting user");
System.out.println("3.exit");
Scanner sc1 = new Scanner(System.in);
System.out.println("enter the choice:");
choice = sc1.nextInt();
switch (choice) {
case 1:
	Scanner scanner =new Scanner(System.in);
    
	 try{      
		 Wallet wallet =new Wallet();
		 Customer customer =new Customer();
		 System.out.println("enter phone number");
		 String phone=scanner.next();
		 valid=paymentwalletservice.validatePhone(phone);
		 if(valid)
		 {
		 customer.setPhoneNumber(phone);
		 System.out.println("enter name");
		 String name=scanner.next();
		 valid=paymentwalletservice.validateName(name);
		 if(valid)
		 {
		 customer.setName(name);
		 
		 System.out.println("enter email");
		 String email=scanner.next();
		 valid=paymentwalletservice.validateEmail(email);
		 if(valid)
		 {
			 customer.setEmailId(email);
			 System.out.println("enter password");
				String password=sc1.next();
				valid=paymentwalletservice.validatePassword(password);
				 if(valid)
				 {
					customer.setStatement("stat");
		 wallet.setPassword(password);
		 wallet.setBalance(new BigDecimal(0));
		 customer.setWallet(wallet);
		 Customer cust = paymentwalletservice.registerCustomer(customer);
		 System.out.println(" Your A/c has been successfully creted, please check your deails below ");
	System.out.println(cust.toString());
		 }
		 }
		 }
		 }
		 }catch(PaymentWalletException paymentwalletexception)
		 {
		 	System.out.println(paymentwalletexception.getMessage());
		 }
  
	break;
case 2:
	try{
	System.out.println("enter phone number");
	number=sc1.next();
	valid=paymentwalletservice.validatePhone(number);
	 if(valid)
	 {
	System.out.println("enter password");
	String password=sc1.next();
	valid=paymentwalletservice.validatePassword(password);
	 if(valid)
	 {
		 valid=paymentwalletservice.checkLogin(number,password);

	 if(valid)
	 {
	
	while(true){
		
		
		System.out.println("1. withdraw amount");
		System.out.println("2.deposit amount");
		System.out.println("3.fund transfer");
		System.out.println("4. show balance");
		System.out.println("5.print transactions");
		System.out.println("6.logout");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the choice:");
		choice = sc.nextInt();
		switch (choice) {

		case 1:
			
			try {

				
			        System.out.println("enter amount to withdraw");
			        BigDecimal balance1=sc.nextBigDecimal();
			        valid=paymentwalletservice.validateMoney(balance1);
					if(valid)
					{
			       	
						com.cg.PaymentWallet.dto.dto.Customer cust3= paymentwalletservice.withdrawMoney(number, balance1);
						System.out.println("Your A/c "+number+" has been debited with amount"+balance1);

						//System.out.println(cust3.toString());
					}
					
				} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		     
			break;
		case 2:
			
			try {
		
				
				
		        System.out.println("enter balance");
		        BigDecimal balance2=sc.nextBigDecimal();
		        valid=paymentwalletservice.validateMoney(balance2);
				if(valid)
				{
		        com.cg.PaymentWallet.dto.dto.Customer cust2;		
				cust2 = paymentwalletservice.depositMoney(number, balance2);
				System.out.println(" Your A/c "+number+" has been credited with amount "+balance2);

				//System.out.println(cust2.toString());
						}
				
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		      
			break;
		case 3:
			
			try {
	
		        System.out.println("enter targer phone number");
		        String phone4=sc.next();
		        valid=paymentwalletservice.validatePhone(phone4);
				if(valid)
				{
		        System.out.println("enter balance");
		        BigDecimal balance3=sc.nextBigDecimal();
		        valid=paymentwalletservice.validateMoney(balance3);
				if(valid)
				{
				  	
				 com.cg.PaymentWallet.dto.dto.Customer cust4 = paymentwalletservice.fundTransfer(number, phone4, balance3);
				 System.out.println(" You have Successfully Transfered amount "+balance3+" to A/C no "+phone4);

				
				}
				}
				//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		      
			break;
		case 4:
			try {
		/*	System.out.println("enter phone number");
	        String phone5=sc.next();
	        error=paymentwalletservice.validatePhone(phone5);
			if(error)
			{*/
			  com.cg.PaymentWallet.dto.dto.Customer cust;
			  cust = paymentwalletservice.showBalance(number);
			  System.out.print("The balance in account " + cust.getName());
				System.out.println(" is " + cust.getWallet().getBalance());
				 
			  //System.out.println(cust.toString());
			//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
			break;
		case 5:
			try {
			/*System.out.println("enter phone number");
	        String phone6=sc.next();
	        error=paymentwalletservice.validatePhone(phone6);
			if(error)
			{*/
			 String result; 
				result = paymentwalletservice.printTransaction(number);
				//System.out.println(result);
				//Set<Entry<String,String>> set = result.entrySet();
				//Iterator<Entry<String, String>> it = set.iterator();
				//while (it.hasNext()) {
					//Entry<String, String> entry = it.next();
					//if((entry.getKey())==phone6)
					//{
					
					//String id11 = entry.getKey();
				//	String dto = entry.getValue();
				 System.out.println("Your Transactions Are:\n");
				Scanner	scanner2=new Scanner(result).useDelimiter("stat");
				while(scanner2.hasNext())
				{
					String str=scanner2.next();
					System.out.println(str);
				}
					
				//	break;
				//}
				//}
				//}
			} catch (PaymentWalletException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}	
			break;
		case 6:
			System.out.println(" you are logged out thankyou for using");
			//System.exit(0);
			details();
			break;
		default:
			System.out.println("enter correct value");
		}
		
	} 
	 }
	 
	 
	 else
	 {
		 System.out.println("please enter correct details");
	 }
	 
	 }
	 }
	 
	 }catch(PaymentWalletException paymentwalletexception)
	 {
	 	System.out.println(paymentwalletexception.getMessage());
	 }
	 
break;
case 3:
	System.out.println("thankyou for using");
	System.exit(0);
	break;
}

} 
    	
    }
}




