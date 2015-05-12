package account;

public class CheckingAccount {
	private String ownerName;
	private double balance;

	public CheckingAccount(String ownerName, double balance) {
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void transfer(CheckingAccount destinationAccount, double amount) {
		// issue #1: in the initial code, it only updated the destination account
		// because it didn't withdraw the amount from the source account
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		// issue #2 bonus: first, I just put 'withdraw(amount)'
		// instaed of putting body of withdraw here but soon relalized doing so
		// prevents not only withdrawing from savings account
		// but also transferring because withdraw method is overridden in SavingsAccount
		// in order to prevent direct withdrawal from savings account
		this.balance -= amount;
		destinationAccount.deposit(amount);
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		this.balance -= amount;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getBalance() {
		return this.balance;
	}
}
