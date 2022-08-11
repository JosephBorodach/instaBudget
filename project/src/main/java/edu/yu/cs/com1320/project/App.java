package edu.yu.cs.com1320.project;

import java.util.*;
import java.time.MonthDay;

public class App {
    Map<String, Account> accounts;
    MonthDay date; 

    /**
     *ASK Joseph TO: 
     make a function getCat that returns the category when I give it the name
     make a function to remove a category from his list; have it return boolean
     */
    public App() {
        this.accounts = new HashMap<>();
    }

    /**
     * Putting an individual user account
     *
     * @throws IllegalArgumentException
     */
    public int putAccount(String email, String password, String firstName, String lastName) {
        if (email == null || password == null || firstName == null || lastName == null || email.isBlank()
                || password.isBlank() || firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (accounts.get(email) != null) {
            throw new IllegalArgumentException();
        }
        Account account = new Account(email, password, firstName, lastName);
        this.accounts.put(password, account);
        return account.hashCode();
    }

    /**
     *
     * @throws IllegalArgumentException
     */
    public boolean putBankAccount(String password, String bankName, String bankAccount, double totalFunds) {
        if (password == null || bankName == null || password.isBlank() || bankName.isBlank()
                || bankAccount == null || totalFunds < 0 || bankAccount.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (accounts.get(password) != null) { //
            throw new IllegalArgumentException();
        }
        Account user = accounts.get(password);
        user.putBankAccount(bankName, new Bank(bankName, totalFunds));
        return true;
    }

    /**
     *
     * @return
     * @throws IllegalArgumentException if that bank account does not exist or if it
     *                                  already has funds allocated to it
     */
    public void FundCategory(String bankName, double amount, String password, String category, int pri) {
        //need to write more exceptions
        if (accounts.get(password).getBank(bankName) == null) {
            throw new IllegalArgumentException();
        }
        Account user = accounts.get(password);
        Bank bank = user.getBank(bankName);
        double money = bank.withdrawFunds(amount);
        Category cate = new Category(category, money, pri); 
        bank.withdrawFunds(money);
        user.addCategory(cate);
    }

    /**
     * @return
     * @throws IllegalArgumentException if that bank account does not already have
     *                                  funds
     */
    public double withdrawFunds(String email, double ammount, String bankName) {
        if (accounts.get(email) == null) {
            throw new IllegalArgumentException();
        }
        Account user = accounts.get(email);
        return user.getBank(bankName).withdrawFunds(ammount); 
    }

    /**
     *
     * @return
     * @throws IllegalStateException if the current date is before the selected date
     * @throws IllegalArgumentException if that bank account does not exist or if it
     *                                  already has funds allocated to it
     */
    public boolean addCategory(String bankName, double cash, String password, String catName, int pri) {
        if(accounts.get(password).getBank(bankName) == null){
            throw new IllegalArgumentException(); 
        }
        Account user = accounts.get(password);
        user.getBank(bankName).withdrawFunds(cash);
        return user.addCategory(new Category(catName, cash, pri));
    }

    /**
     *
     * @return
     * @throws IllegalStateException if the current date is before the selected date
     * @throws IllegalArgumentException if that bank account does not exist or if it
     *                                  already has funds allocated to it
     * 
     */
    public boolean deleteCategory(String password, String bankName, String catName) {
        if(MonthDay.now().isBefore(date)){ throw new IllegalStateException("it's before the date");}
        if (accounts.get(password) == null || accounts.get(password).getBank(bankName) == null
                || accounts.get(password).getCategory(catName).hasFunds() == false) {
            throw new IllegalArgumentException();
        }
        Account user = accounts.get(password);
        Category cat = user.getCategory(catName); //ask sam to make getCategory method that returns the category
        return accounts.get(password).removeCategory(catName);
    }

    public void setDate(MonthDay date){
        this.date = date; 
    }

}
