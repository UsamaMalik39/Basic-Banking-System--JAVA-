import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
	
	public static void main(String []args) throws IOException {
		
		Scanner scannerForInput=new Scanner(System.in);
		char option='\0';
		BankingApplication user1=new BankingApplication();
		System.out.println("Write your user name.");
		String UserName=scannerForInput.next();
		user1.CreateMyFile(UserName);
		// recursive calls
		do 
		{
			display();
			// First get the string, then trim it so that no useless space are used, and finally pick the char at 0th index
			option=scannerForInput.next().trim().charAt(0);
			// five different scenarios now 
			switch(option)
			{
			case 'a':
				System.out.println("\n PLease enter the amount you want to deposit. ");
				int DepAmount=scannerForInput.nextInt();
				user1.DepositMoney(DepAmount);
				user1.CreateMyFile(UserName);
				break;
			case 'b':
				System.out.println("\n PLease enter the amount you want to transact. ");
				int TraAmount=scannerForInput.nextInt();
				user1.PerformTransaction(TraAmount);
				user1.CreateMyFile(UserName);
				break;
			case 'c':
				user1.BalanceInquiry();
				break;
			case 'd':
				user1.GetLastTransactionStatus();
				break;
			
			}
			
			
		}
		while(option!='e' );
		
		
		
		
		
	}
	
	public static void display()
	{
		System.out.println("\t WELCOME SENORA\n");
		System.out.println("// // // // // // // // // // // // // // // // // // // // // // //\n");
		System.out.println("\t MENU \t\n");
		System.out.println("(a) Deposit");
		System.out.println("(b) Make Transaction");
		System.out.println("(c) Balance Inquiry");
		System.out.println("(d) Last Transaction Record");
		System.out.println("(e) Exit\n");
		System.out.println("// // // // // // // // // // // // // // // // // // // // // // //");
		
	}

	
	
}

class BankingApplication
{
	static int Balance=0;
	int amount=0;
	int LastTransaction=0;
	
	public static void CreateMyFile(String FileName)
	{
		try {
			//Create a new file for client
			File myFile=new File(FileName+".txt");
			if(myFile.createNewFile())
				System.out.println("FIle created: "+ myFile.getName());
			else
				System.out.println("Already exists. ");
			//Let file writer know which file to write
			
			FileWriter fw=new FileWriter(myFile.getName());
			//data to enter in file
			String userName=FileName;
			
			//sending data to be written
			fw.write(userName);
			fw.write("\n Balance: \t");
			fw.write(String.valueOf(Balance));
			//closing file write
			fw.close();
			}
		//for negative case
			catch(IOException e)
			{
				System.out.println("An error occured. ");
				e.printStackTrace();
			}
			
	}
	
	
	
	//function to deposit money
	//takes an arg of amount
	void DepositMoney(int add)
	{
		Balance=Balance+add;
		LastTransaction=add;
		System.out.println("///////////////////////////////////////////");
		System.out.println("Money Deposited Successfully. ");
	}
	//function for transaction
	
	void PerformTransaction(int sub)
	{
		Balance=Balance-sub;
		LastTransaction=-sub;
		System.out.println("///////////////////////////////////////////");
		System.out.println("Transaction Completed");
	}
	
	//Function for last transaction
	void GetLastTransactionStatus()
	{
		System.out.println("///////////////////////////////////////////");
		if(LastTransaction >= 0) 
			System.out.println("Amount was deposited: "+Math.abs(LastTransaction));
		
		else
			System.out.println("Amount was Transacted: "+Math.abs(LastTransaction));
			
	}
	
	//function for balance inquiry
	void BalanceInquiry()
	{
		System.out.println("///////////////////////////////////////////");
		System.out.println("Balance Inquiry: "+Balance);
	}
	
	
}
