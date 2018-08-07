package com.cg.jpa.dao;

import com.cg.jpa.beans.Account;
import com.cg.jpa.exception.AccountException;

public interface IWalletDao {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo,double depAmt) throws AccountException;
	Account withdraw(String mobileNo, double withdrawAmt) throws AccountException;

Account printTransactionDetails(String mobileNo) throws AccountException;

}
