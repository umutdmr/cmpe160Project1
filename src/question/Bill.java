
package question;

public class Bill {

	private double limitingAmount;
	private double currentDebt;
	private double paid;
	//constructor of Bill class
	public Bill(double limitingAmount)
	{
		this.limitingAmount = limitingAmount;
		currentDebt = 0;
		paid = 0;
	}

	//if limitingAmount exceeded return true
	public boolean check(double amount)
	{
		if(amount > limitingAmount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//adding debts to the bill
	public void add(double amount)
	{
		this.currentDebt += amount;
	}

	//paying the bills with the given amount
	public void pay(double amount)
	{
		if(amount > this.currentDebt)
		{
			this.paid += currentDebt;
			this.currentDebt = 0;
			
		}
		else
		{
			this.currentDebt -= amount;
			this.paid += amount;
		}
	}

	//for changing the limitingAmount
	public void changeTheLimit(double amount)
	{
		this.limitingAmount = amount;
	}

	//getter methods for limitingAmount and currentDebt
	public double getLimitingAmount()
	{
		return limitingAmount;
	}

	public double getCurrentDebt()
	{
		return currentDebt;
	}
	public double getPaid() {
		return paid;
	}

}

