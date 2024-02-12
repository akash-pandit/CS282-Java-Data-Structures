public class Account 
{
	private double balance;
	private double rate;
	
	public Account() {
		balance = 100.00;
		rate = 0.03;
	}

	public Account(double balance, double rate) {
		this.balance = balance;
		this.rate = rate;
	}
	
	public double getBalance() {
		return balance;
	}

	public double getRate() {
		return rate;
	}

	public void displayBalance()
	{
		String output = "The balance is $%.2f";
		output = String.format(output, balance);
		System.out.println(output);
	}
	
	public void displayRate() {
		String output = "The rate is $%.2f";
		output = String.format(output, rate);
		System.out.println(output);
	}
	
	public boolean deposit(double amount) {
		if (amount < 0) {
			throw new BalanceError("You cannot deposit a negative amount of money.");
		}
		balance += amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		if (amount > balance) {
			throw new BalanceError("You cannot withdraw more money than is in your account.");
		}
		balance -= amount;
		return true;
	}
	 
	public boolean accrueInterest(int months) {
		for (int i = 0; i < months; i++) {
			balance = ((double) (balance * rate) / 12) + balance;
		}
		return true;
	}
}

public class BalanceError extends Error {}