
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];


		
		PrintStream outstream1;
		try
		{
			outstream1 = new PrintStream(outFile);
		}
		catch (FileNotFoundException e2)
		{
			e2.printStackTrace();
			return;
		}
		int customerID = 0;
		int operatorID = 0;
		//set each customers[] elements to null
		for(int i = 0; i < C; i++)
		{
			customers[i] = null;
		}

		//set each operators[] elements to null
		for(int j = 0; j < O; j++)
		{
			operators[j] = null;
		}
		for(int i = 0; i < N; i++)
		{
			int input = reader.nextInt();
			switch(input)
			{
				case 1:
					customers[customerID] = new Customer(customerID, reader.next(), reader.nextInt(), operators[reader.nextInt()], reader.nextDouble());
					customerID++;
					break;
				case 2:
					operators[operatorID] = new Operator(operatorID, reader.nextDouble(), reader.nextDouble(), reader.nextDouble(), reader.nextInt());
					operatorID++;
					break;
				case 3:
					int firstID = reader.nextInt();
					int secondID = reader.nextInt();
					int minute = reader.nextInt();
					customers[firstID].talk(minute, customers[secondID]);
					break;
				case 4:
					int first = reader.nextInt();
					int second = reader.nextInt();
					int quantity = reader.nextInt();
					customers[first].message(quantity, customers[second]);
					break;
				case 5:
					customers[reader.nextInt()].connection(reader.nextDouble());
					break;
				case 6:
					customers[reader.nextInt()].getBill().pay(reader.nextDouble());
					break;
				case 7:
					customers[reader.nextInt()].setOperator(operators[reader.nextInt()]);
					break;
				case 8:
					customers[reader.nextInt()].getBill().changeTheLimit(reader.nextDouble());
					break;

			}
		}
		Customer maxInt = customers[0];
		Customer maxMes = customers[0];
		Customer maxTalk = customers[0];
		
		for(int j = 0; j < O; j++)
		{
			outstream1.println("Operator " + j + " : " + operators[j].totalTalk + " " + operators[j].totalMessage + " " + String.format("%.2f", operators[j].totalInternet));
		} 
		for(int k = 0; k < C; k++)
		{
			outstream1.println("Customer " + k + " : " + String.format("%.2f", customers[k].getBill().getPaid()) + " " + String.format("%.2f", customers[k].getBill().getCurrentDebt()));
			if(customers[k].totalInternet > maxInt.totalInternet)
			{
				maxInt = customers[k];
			}
			if(customers[k].totalMessage > maxMes.totalMessage)
			{
				maxMes = customers[k];
			}
			if(customers[k].totalTalk > maxTalk.totalTalk)
			{
				maxTalk = customers[k];
			}
		}
		outstream1.println(maxTalk.name + " : " + maxTalk.totalTalk);
		outstream1.println(maxMes.name + " : " + maxMes.totalMessage);
		outstream1.print(maxInt.name + " : " + String.format("%.2f", maxInt.totalInternet));
		

	} 
}


