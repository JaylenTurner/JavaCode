/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccountGUIOutline_JaylenTurner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jaylenturner
 */
public class BankAccountInfo {
    /*
        private char AccountType;
        private String pin;
        private String accountNumber;
        private double balance;
        private String name;

    public char getAccountType() {
        return AccountType;
    }

    public void setAccountType(char AccountType) {
        this.AccountType = AccountType;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
    public static void main(String[] args) throws IOException {
    FileWriter printer = new FileWriter("customer.txt");
    Scanner fileReader = new Scanner(new File("customer.txt"));
    
    FileWriter accountsPrinter = new FileWriter("Accounts.txt");
    Scanner accountsFileReader = new Scanner(new File ("Accounts.txt"));
        
    printer.write("hello");
    printer.close();
    
    System.out.println(fileReader.next());
    }
*/
        private double balance;
    private int numDeposits;
    private int numWithdrawls;
    private double interestRate;
    private double monthlyServiceCharge;
    private String pincode;
   
    public BankAccountInfo(double bal, double intRate, double mon){
        balance = bal;
        interestRate = intRate;
        monthlyServiceCharge = mon;
    }
    
    public void deposit(double amount){
        balance += amount;
        numDeposits += 1;
    }
    
    public void withdraw(double amount){
        balance -= amount;
        numWithdrawls++;
    }
    
    private void calcInterest(){
        double monthlyInterestRate = interestRate / 12;
        double monthlyInterest = balance * monthlyInterestRate;
        balance += monthlyInterest;
    }
    
    public void monthlyProcess(){
        balance -= monthlyServiceCharge;
        calcInterest();
        numWithdrawls = 0;
        numDeposits = 0;
        monthlyServiceCharge = 0;
    }

    public void setMonthlyServiceCharge(double monthlyServiceCharge) {
        this.monthlyServiceCharge = monthlyServiceCharge;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumDeposits() {
        return numDeposits;
    }

    public int getNumWithdrawls() {
        return numWithdrawls;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMonthlyServiceCharge() {
        return monthlyServiceCharge;
    }

    public String getPincode() {
        return pincode;
    }
    
    public void setAccountBalance(double bal){
        balance = bal;
    }
    
    
    
}

