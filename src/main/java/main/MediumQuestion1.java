package main;
import java.util.Scanner;

abstract class Customer 
{
	private String name, address, mobileNumber;
	private Integer age;
	Customer(String name, String address, Integer age, String mobile) 
	{
		this.name = name;
		this.address = address;
		this.age = age;
		this.mobileNumber = mobile;
	}
	public String toString() 
	{
		return "Name: " + this.name+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Age: " + this.age+"\n"+"Address: "+ this.address;
	}
	abstract Double getBillAmount(Double amt);
}
class SeniorCitizenCustomer extends Customer 
{
	SeniorCitizenCustomer(String name, String address, Integer age, String mobile) 
	{
		super(name, address, age, mobile);
	}	
	Double getBillAmount(Double amount) 
	{
		Double bill =null;
		System.out.println("Your bill amount is Rs. "+ amount+". Congrats! As you are a Senior Citizen customer, you are eligible for a discount!");
		bill=amount-(amount*0.12);
		System.out.println("You have to pay Rs "+bill);
		return bill;
	}
}
class PrivilegeCustomer extends Customer 
{
	PrivilegeCustomer(String name, String address, Integer age, String mobile) 
	{
		super(name, address, age, mobile);
	}
	Double getBillAmount(Double amount) 
	{
		Double bill = null;
		System.out.println("Your bill amount is Rs. "+ amount+". Congrats! As you are a Privileged customer, you are eligible for a discount!");
		bill=amount-(amount*0.3);
		System.out.println("You have to pay Rs "+bill);
		return bill;
	}
}

public class MediumQuestion1 
{
	static Scanner s = new Scanner(System.in);
	static String name, address, phn;
	static Integer age;
	static Double purchasedAmt;
	public static void main(String[] args) 
	{	
		System.out.print("1)Privilege Customer" + "\n" + "2)Senior Citizen \n");
		System.out.println("Enter Customer Type: ");
		int select = s.nextInt();
		switch (select) 
		{
			case 1:
					takeInput();
					Customer cust = new PrivilegeCustomer(name, address, age, phn);
					//Double billAmt = cust.getBillAmount(purchasedAmt);
					System.out.println("Bill details");
					System.out.println(cust.toString()+"\n"+cust.getBillAmount(purchasedAmt));
					break;
			case 2:
					takeInput();
					Customer cust1 = new SeniorCitizenCustomer(name, address, age, phn);
					System.out.println("Bill details");
					System.out.println(cust1.toString()+"\n"+cust1.getBillAmount(purchasedAmt));
					break;
			default:
					System.out.println("Invalid Customer Type");
					break;
		}
	}

	public static void takeInput() 
	{

		System.out.println("Enter the name: ");		
		s.nextLine();
		name = s.nextLine();
		System.out.println("Enter the age: ");
		age = s.nextInt();
		System.out.println("Enter the address: ");
		s.nextLine();
		address = s.nextLine();	
		System.out.println("Enter the mobile number: ");
		phn = s.nextLine();
		System.out.println("Enter the purchased amount: ");
		purchasedAmt = s.nextDouble();
	}

}