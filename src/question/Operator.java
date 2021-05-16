
package question;
public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	int ID;
	int totalTalk;
	int totalMessage;
	double totalInternet;
	private int discountRate;
	private double talkingCharge, messageCost, networkCharge;
	
	//constructor of Operator class
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate)
	{
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
		totalTalk = 0;
		totalMessage = 0;
		totalInternet = 0;
	}

	//for calculating the total amount pay for talking
	public double calculateTalkingCost(int minute, Customer customer)
	{
		double totalAmount = minute * talkingCharge;
		return totalAmount;
	}

	//for calculating the total amount pay for messaging
	public double calculateMessageCost(int quantity, Customer customer, Customer other)
	{
		double totalAmount = quantity * messageCost;
		return totalAmount;
	}

	//for calculating the total amount pay for networking
	public double calculateNetworkCost(double amount)
	{
		double totalAmount = amount * networkCharge;
		return totalAmount;
	}

	//getter methods for talkingCharge, messageCost, networkCharge, discountRate
	public int getDiscountRate()
	{
		return discountRate;
	}
	public double getTalkingCharge()
	{
		return talkingCharge;
	}
	public double getMessageCost()
	{
		return messageCost;
	}
	public double getNetworkCharge()
	{
		return networkCharge;
	}

	//setter methods for talkingCharge, messageCost, networkCharge, discountRate
	public void setDiscountRate( int discountRate)
	{
		this.discountRate = discountRate;
	}
	public void setTalkingCharge(double talkingCharge)
	{
		this.talkingCharge = talkingCharge;
	}
	public void setMessageCost(double messageCost)
	{
		this.messageCost = messageCost;
	}
	public void setNetworkCharge(double networkCharge)
	{
		this.networkCharge = networkCharge;
	}



	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

