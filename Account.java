
public class Account 
{
	private double balance;
	private double rate;
	
	public Account()
	{
		balance = 100.00;
		rate = 0.03;
	}
	
	public void displayBalance()
	{
		String output = "The balance is %.2f";
		output = String.format(output, balance);
		System.out.println(output);
	}
	
	//ToDo Display Rate
	
	//ToDo Deposit Money
	
	//ToDo Withdraw Money
	
	//ToDo Project Interest
}