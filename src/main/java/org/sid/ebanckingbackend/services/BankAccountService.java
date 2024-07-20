package org.sid.ebanckingbackend.services;

import org.sid.ebanckingbackend.entities.BankAccount;
import org.sid.ebanckingbackend.entities.CurrentAccount;
import org.sid.ebanckingbackend.entities.Customer;
import org.sid.ebanckingbackend.entities.SavingAccount;
import org.sid.ebanckingbackend.exceptions.BalanceNotSufficientException;
import org.sid.ebanckingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebanckingbackend.exceptions.CustomerNotfoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotfoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotfoundException;
    List<Customer> listCustomer();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfert(String accountIdSource,String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


}
