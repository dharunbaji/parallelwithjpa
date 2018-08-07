package com.cg.jpa.service;

import com.cg.jpa.beans.Account;
import com.cg.jpa.dao.IWalletDao;
import com.cg.jpa.dao.WalletDao;
import com.cg.jpa.exception.AccountException;

public class WalletServiceImpl implements IWalletService {
IWalletDao wdao = new WalletDao();

public String createAccount(Account acc) throws AccountException {
	if (!acc.getMobileNo().matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
		if (acc.getName().isEmpty() || acc.getName() == null) {
		throw new AccountException("Name cannot be empty");
		} else {
		if (acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
		throw new AccountException(
		"Name should start with capital letter and should contain only alphabets");
		}
		}
		if (acc.getBalance() < 0) {
		throw new AccountException("Balance should be greater than zero");
		}
		if (!acc.getEmail().matches("[a-z]+@[a-z]+\\.com")) {
		throw new AccountException("Enter valid emailid");
		}

		return wdao.createAccount(acc);
}

public double showBalance(String mobileNo) throws AccountException {
	if (!mobileNo.matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
		return wdao.showBalance(mobileNo);
}

public Account deposit(String mobileNo, double depositAmt)
		throws AccountException {
	if (!mobileNo.matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
	
		if (depositAmt <= 0) {
		throw new AccountException(
		"Deposit amount must be greater than zero");
		}
		 
		return wdao.deposit(mobileNo,depositAmt);
		
}

public Account withdraw(String mobileNo, double withdrawAmt)
		throws AccountException {
	if (!mobileNo.matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
		
		if ( withdrawAmt <= 0) {
		throw new AccountException(
		"The amount to be withdrawn should be greater than available balance and greater than zero");
		}
		
		Account acc1 = wdao.withdraw(mobileNo,withdrawAmt);
		return acc1;
}

public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
		double transferAmt) throws AccountException {
	if (!sourceMobileNo.matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
		if (!destMobileNo.matches("\\d{10}")) {
		throw new AccountException("Mobile number should contain 10 digits");
		}
		IWalletService service = new WalletServiceImpl();
		Account acc1 = service.withdraw(sourceMobileNo, transferAmt);
		Account d2 = service.deposit(destMobileNo, transferAmt);
		return true;
}

public Account printTransactionDetails(String mobileNo) throws AccountException {
	return wdao.printTransactionDetails(mobileNo);
}
	

}