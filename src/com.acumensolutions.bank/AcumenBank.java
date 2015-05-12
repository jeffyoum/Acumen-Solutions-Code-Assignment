package com.acumensolutions.bank;

import account.CheckingAccount;
import account.SavingsAccount;

public class AcumenBank {

	public static void main(String[] args) {
		System.out.println("Welcome to Acumen Bank!\n");

		CheckingAccount michaelsAccount = new CheckingAccount("Michael", 5000);
		CheckingAccount gobsAccount = new CheckingAccount("Gob", 2000);

		System.out.println("Open Checking Accounts:\n");
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		System.out.println();
		System.out.println("Making transfer of $1000...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return;
		}

		michaelsAccount.transfer(gobsAccount, 1000);

		System.out.println("Updated Account Details:\n");
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		// sample code for savings account implementation

		// Initialize new savings account with initial balance of $30,000 and 0.89% interest
		SavingsAccount acesSavingsAccount = new SavingsAccount("Ace", 30000, .0089);

		// Initialize new savings account with initial balance of $10,000 and 0.56% interest
		SavingsAccount garysSavingsAccount = new SavingsAccount("Gary", 10000, .0056);

		// print out initial account info
		System.out.println("\nOpen Savings Accounts:\n");
		printAccountDetails(acesSavingsAccount);
		System.out.println();
		printAccountDetails(garysSavingsAccount);

		acesSavingsAccount.transfer(garysSavingsAccount, 5000);

		// print out updated account info after the transfer
		System.out.println("\nAfter Transfer:\n");
		printAccountDetails(acesSavingsAccount);
		System.out.println();
		printAccountDetails(garysSavingsAccount);

		// apply 2 years of interest to the savings accounts
		acesSavingsAccount.applyInterest(2);
		garysSavingsAccount.applyInterest(2);

		// print out updated account info aftehr applying the interest
		System.out.println("\nAfter Applying Interest:\n");
		printAccountDetails(acesSavingsAccount);
		System.out.println();
		printAccountDetails(garysSavingsAccount);

		// test withdraw on savings account
		acesSavingsAccount.withdraw(1000);
		garysSavingsAccount.withdraw(1000);

		// print out updated account info aftehr applying the interest
		System.out.println("\nAfter Withdrawing:\n");
		printAccountDetails(acesSavingsAccount);
		System.out.println();
		printAccountDetails(garysSavingsAccount);
	}

	private static void printAccountDetails(CheckingAccount account) {
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
	}
}
