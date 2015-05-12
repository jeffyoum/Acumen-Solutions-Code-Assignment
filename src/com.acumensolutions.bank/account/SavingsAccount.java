package account;

import java.lang.Math;

public class SavingsAccount extends CheckingAccount {
  private double interest;

  // constructor
  public SavingsAccount(String ownerName, double balance, double interest) {
    super(ownerName, balance);
    if (interest > 1.0 || interest < 0.0) {
      throw new IllegalArgumentException("Invalid interest rate");
    }
    this.interest = interest;
	}

  // issue #2
  public void applyInterest(int year) {
    if (year < 0) {
      throw new IllegalArgumentException("Year cannot be negative");
    }
    double balance = super.getBalance();
    super.deposit((balance * Math.pow(1 + this.interest, year)) - balance);
  }

  @Override
  public void withdraw(double amount) {
		System.out.println("You cannot withdraw directly from a savings account");
	}
}
