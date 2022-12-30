package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        // minimum balance is 0 by default

    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        double balance = super.getBalance();
        if (balance < amount) {
            throw new Exception("Insufficient Balance");
        }
        if (amount > maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed");
        balance = balance - amount;
        setBalance(balance);


    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that bank gives simple interest on current amount
        double simpleInterest = 0;
        simpleInterest = getBalance() * years * rate;
        simpleInterest = simpleInterest / 100;
        return getBalance() + simpleInterest;

    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        rate = (rate / (double) times) + 1;
        years = (years * times);
        rate = Math.pow(rate, (double) years);
        double balance = this.getBalance();
        balance = balance * rate;
        return balance;
    }

}
