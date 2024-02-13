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
		String output = "The balance is $%,.2f\n";
		output = String.format(output, balance);
		System.out.println(output);
	}
	
	public void displayRate() {
		String output = "The interest rate is %f percent\n";
		output = String.format(output, rate * 100);
		System.out.println(output);
	}
	
	public boolean deposit(double amount) {
		if (amount < 0) {
			System.out.println("You cannot deposit a negative amount of money. " + 
			"Please input a valid amount, or 0 to cancel this transaction.\n");
			return false;
		}
		balance += amount;
		return true;
	}
	
	public boolean withdraw(double amount) {
		if (amount < 0) {
			System.out.println("You cannot withdraw a negative amount of money. "  +
			"To deposit a balance, please use the intended deposit function.\n");
		}
		if (amount > balance) {
			System.out.println("You cannot withdraw more money than is in your account. " +
			"Please input a valid amount, or 0 to cancel this transaction.\n");
			return false;
		}
		balance -= amount;
		return true;
	}
	 
	public boolean accrueInterest(int months) {
		if (months < 0) {
			System.out.println("You cannot track interest with a negative months value. " +
			"Please input a valid amount, or 0 to not accrue any interest.");
			return false;
		}
		double interestAccrued = 0;
		for (int i = 0; i < months; i++) {
			interestAccrued += (double) (balance * rate) / 12;
			balance = ((double) (balance * rate) / 12) + balance;
		}

		System.out.println(String.format("Accrued $%,.2f interest over %,d months.\n", interestAccrued, months));

		return true;
	}
}