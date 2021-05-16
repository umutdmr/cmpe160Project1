
package question;

public class Customer {
	
	int ID;
	int totalTalk;
	int totalMessage;
	double totalInternet;
	private int age;
	String name;
	private Operator operator;
	private Bill bill;

	//constructor of Customer class
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount)
	{
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);	
		totalTalk = 0;
		totalMessage = 0;
		totalInternet = 0;
	}

	//for customers to talk via the operator
	public void talk(int minute, Customer other)
	{
		if(other.ID != this.ID)
		{
			double debt = operator.calculateTalkingCost(minute, other);
			if(this.age < 18 || this.age > 65)
			{
				debt *=  (100 - operator.getDiscountRate()) / 100.0;
			}
			if(!bill.check(debt + bill.getCurrentDebt()))
			{
				bill.add(debt);
				this.totalTalk += minute;
				this.operator.totalTalk += minute;
				other.operator.totalTalk += minute;
				other.totalTalk += minute;

			}
			
			
			
		}
		
	}

	//for customers to send message
	public void message(int quantity, Customer other)
	{
		if(other.ID != this.ID)
		{
			double debt = operator.calculateMessageCost(quantity,  Customer.this ,other);
			if(operator.ID == other.operator.ID)
			{
				debt *=  (100 - operator.getDiscountRate()) / 100.0;
			}
			if(!bill.check(debt+ bill.getCurrentDebt()))
			{
				bill.add(debt);
				this.totalMessage += quantity;
				this.operator.totalMessage += quantity;
			
			}
		}
	}

	//for customers to connect the internet
	public void connection(double amount) 
	{
		double debt = operator.calculateNetworkCost(amount);
		if(!bill.check(debt + bill.getCurrentDebt()))
		{
			bill.add(debt);
			this.totalInternet += amount;
			this.operator.totalInternet += amount;
		}
	}

	//getter methods
	public int getAge()
	{
		return age;
	}
	public Operator getOperator()
	{
		return operator;
	}
	public Bill getBill()
	{
		return bill;
	}

	//setter methods
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}
	public void setBill(Bill bill)
	{
		this.bill = bill;
	}

}

