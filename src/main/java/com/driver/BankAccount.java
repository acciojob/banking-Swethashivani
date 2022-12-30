package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        double a = Math.pow(10, digits - 1);
        double b = Math.pow(10, digits);

        String accountNumber = "";
        for (int i = (int) a; i < (int) b; i++) {
            int sumOfDigits = 0;
            int temp = i;
            while (temp > 0) {
                sumOfDigits = sumOfDigits + (temp % 10);
                temp = temp / 10;
            }
            if (sumOfDigits == sum) {
                accountNumber = Integer.toString(i);
                return accountNumber;
            }
        }

        if (accountNumber.length() != digits)
            throw new Exception("Account Number can not be generated");
        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = this.balance + amount;

    }

    public void withdraw(double amount) throws  Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if( (this.balance - amount) < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        this.balance = this.balance - amount;


    }

}
