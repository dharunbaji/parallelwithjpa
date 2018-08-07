package com.cg.jpa.service;

import com.cg.jpa.beans.Account;
import com.cg.jpa.exception.AccountException;

public interface IWalletService {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws  AccountException;
	Account deposit(String mobileNo,double depositAmt) throws  AccountException;
	Account withdraw(String mobileNo,double withdrawAmt) throws  AccountException;
	boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmt) throws  AccountException;
	Account printTransactionDetails(String mobileNo) throws  AccountException;
}
