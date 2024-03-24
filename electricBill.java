import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class electricBill{
 void printWelcome(){
 	System.out.println("\n\n           		 ********************************");
    System.out.println("           		 *                              *");
    System.out.println("           		 *      \u001B[32m Welcome to ZSEBM      \u001B[0m *");
    System.out.println("           		 *                              *");
    System.out.println("           		 ********************************\n\n ");
 }
 public static void main(String []args){
		Scanner input = new Scanner(System.in);
		electricBill mainObj = new electricBill();
		EBAccount accountObject = new EBAccount();
		mainObj.printWelcome();
		System.out.println("Enter 1 for a Admin");	
		System.out.println("Enter 2 for a member");
		int userCheck = input.nextInt();
		switch(userCheck){
			case 1:
				mainObj.inputUserGet(true);
				break;
			case 2:
				mainObj.getMemberValueFromText();
				mainObj.inputUserGetMem(true);
				mainObj.memberObj.checkUser(mainObj);
				break;
			default:
				System.out.println("\u001B[31m "+ userCheck+" is a Invalid input.\u001B[0m");
				mainObj.userCheckMemOrAcc();
				break;
		}
			
	    }
	    
 String userName;
 int userNumber;
 Scanner input = new Scanner(System.in);
void inputUserGet(boolean yesORNo){
		try{
	 	System.out.println("Enter the user id");
	 	if(yesORNo != true){
			input.nextLine();
		}
		userName = input.nextLine();
		System.out.println("Enter the Password");
		userNumber = input.nextInt();
		accountObject.userCheck(userName,userNumber,this);
		}
		catch(Exception e){
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			inputUserGet(false);	
		}
 	} 

void inputUserGetMem(boolean result){
		try{
		System.out.println("Enter the user id");
		if(result !=true){
			input.nextLine();
		}
		userName = input.nextLine();
		System.out.println("Enter the EB no.");
		userNumber = input.nextInt();
	  }
	catch(Exception e){
		System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
		inputUserGetMem(false);
	}
}
 void iputForAccount(){
 	Scanner input = new Scanner(System.in);
 		try{
		 	System.out.println("Enter the user name");
			userName = input.nextLine();
			System.out.println("Enter the EB no.");
			userNumber = input.nextInt();
		}
		catch(Exception e){
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			input.nextLine();
			iputForAccount();
		}
 	} 
 	
 	void userCheckMemOrAcc(){
 		electricBill mainObj = new electricBill();
 		System.out.println("\n\nEnter 1 for a Admin");	
		System.out.println("Enter 2 for a member");
		int userCheck;
		try{
			userCheck = input.nextInt();
			switch(userCheck){
			case 1:
				mainObj.inputUserGet(true);
				break;
			case 2:
				mainObj.getMemberValueFromText();
				mainObj.inputUserGetMem(true);
				mainObj.memberObj.checkUser(mainObj);
				break;
			default:
				System.out.println("\u001B[31m "+ userCheck+" is a Invalid input.\u001B[0m\n\n");
				userCheckMemOrAcc();
				break;
			}
		}
		catch(Exception e){
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			System.out.println("\n\n");
			userCheckMemOrAcc();
		}
		
 	}

	void memberRepeateValues(){
		inputUserGetMem(false);
		memberObj.checkUser(this);
	} 	
 void accountCreate(){
 	try{
 		Scanner input = new Scanner(System.in);
 		System.out.println("Enter the name");
		userName = input.nextLine();
		System.out.println("Enter the EB no.");
		userNumber = input.nextInt();
		input.nextLine();
		System.out.println("Enter your area place ");
		userNumber = input.nextInt();
	}
	catch(Exception e){
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			input.nextLine();
			accountCreate();
	}
 }					
 static double amountCalculation(int inputUnits){
 		double amountCalculation;
		if(inputUnits<=100){
			amountCalculation = 0;	
		}
		else if(inputUnits<=200){
			amountCalculation = (inputUnits - 100)*2.25;	
		}
		else if(inputUnits<=400){
			amountCalculation = ((inputUnits - 200)*4.50) +(100*2.25);	
		}
		else if(inputUnits<=500){
			amountCalculation =  ((inputUnits - 400)*6.00)+(200*4.50) +(100*2.25);	
		}
		else if(inputUnits<=800){
			amountCalculation = ((inputUnits - 500)*8.50)+(100*6.00)+(200*4.50) +(100*2.25);	
		}
		else {
			amountCalculation = ((inputUnits - 800)*10.00) + (300*8.50)+(100*6.00)+(200*4.50) +(100*2.25);
		}
		return amountCalculation;
	}

	String[][] userDetails ;
	Path filePath = Paths.get("gopika.txt");
	List<String> lines;
	void getMemberValueFromText(){
	try {
            lines = Files.readAllLines(filePath);
            userDetails= new String[lines.size()][2];
            int count = 0;
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    String[] values = line.split("-");
                    userDetails[count] = values;
                    count++;
                }
                 
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      void setValuesToText(List<String> lines, String[][] userDetails, Path filePath) {
      	
     	userDetails[memberObj.userIndexNo] = memberObj.userDetailsInput;
       	String[] individualArray = new String[lines.size()];
        int count = 0;
        for (String[] userValues : userDetails) {
            individualArray[count] = String.join("-", userValues);
            count++;
        }
        try {
              String modifiecString = String.join("", individualArray);
              Files.write(filePath, "".getBytes());
               for (String element : individualArray) {
                Files.write(filePath, (element + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
              }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
}
	
	void thankyouPrint(){
		System.out.println("\n\n           		 ********************************");
    	System.out.println("           		 *                              *");
    	System.out.println("           		 *    \u001B[32m        Thank you         \u001B[0m*");
    	System.out.println("           		 *                              *");
    	System.out.println("           		 ********************************\n\n ");
	}

EBMembers memberObj = new EBMembers();
	void memberMenuList(){
				System.out.print("\n\n       -------------------------------------- \n\n");
				System.out.format("     | %-38s |\n\n", "      1. View Profile");
           		System.out.format("     | %-38s |\n\n", "      2. Payment Details");
            	System.out.format("     | %-38s |\n\n", "      3. Bill Payment");
            	System.out.format("     | %-38s |\n\n", "      4. Logout");
				System.out.print("       -------------------------------------- \n\n");
				System.out.print("Enter your choice (1-4): ");
		

		Scanner input = new Scanner(System.in);
		try{
		int userInfo = input.nextInt();
		switch(userInfo){
		  case 1:
		  		 memberObj.displayPersonalInfo();
		  		 memberMenuList();
		  		 break;
		  case 2:
		  		 memberObj.displayDetails();
		  		 memberMenuList();
		  		 break;	 
		  case 3:
		  		double totalAmount = memberObj.payPendingBill();
			if( totalAmount> 0){
			System.out.println("Total amount paid is "+ totalAmount);
			System.out.println("Do you want to pay that amount ? Yes(1) or no(2)");
			int paymentInput = input.nextInt();
				memberObj.paymentInput(paymentInput, this);
				setValuesToText(lines, userDetails, filePath);
			}
			else{

			}
			memberMenuList();
			break;
		case 4:
			thankyouPrint();
			break;
		default:
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			System.out.println("\n\n");
			memberMenuList();
			break;
		}
	}
	catch(Exception e){
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			System.out.println("\n\n");
			memberMenuList();
		}
	}
		
	
	EBAccount accountObject = new EBAccount();
		 void accountMenuList(){
		 		System.out.print("\n\n       -------------------------------------- \n\n");
				System.out.format("     | %-38s |\n\n", "      1. View Profile");
           		System.out.format("     | %-38s |\n\n", "      2. Create New Member Account");
            	System.out.format("     | %-38s |\n\n", "      3. Member Details");
            	System.out.format("     | %-38s |\n\n", "      4. Logout");
				System.out.print("       -------------------------------------- \n\n");

				System.out.print("Enter your choice (1-4): ");
				try{
				int accountChoose = input.nextInt();
				switch (accountChoose) {
					case 1:
						accountObject.displayInfo();
						accountMenuList();
						break;
					case 2:
						createNewAccountInput();
						accountMenuList();
						break;
					case 3:
						accountObject.addDataToMember(this, memberObj);
						accountMenuList();
						break;
					case 4:
						thankyouPrint();
						break;
					default:
						System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
						System.out.println("\n\n");
						accountMenuList();
						break;
					}
				}
				catch(Exception e){
						System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
						System.out.println("\n\n");
						accountMenuList();
				}
				
		 }
		String placeName;
		int accountNumber;
		 void createNewAccountInput(){
		 	try{
		 	System.out.print("Enter your name ");
		 	input.nextLine();
		 	userName = input.nextLine();
		 	System.out.print("Enter your EB No. :");
		 	accountNumber = input.nextInt();
		 	System.out.println("Enter your place name ");
		 	input.nextLine();
		 	placeName = input.nextLine();
		 	accountObject.newUserIntoFile(this);
		 }
		 catch(Exception e){
		 	System.out.println("\u001B[31m  Invalid input.\u001B[0m\n\n");
		 	createNewAccountInput();
		 }
		 }

int inputValues;
	void userDataMenu(){
		System.out.println("\n");
			System.out.print("       -------------------------------------- \n\n");
			System.out.format("     | %-38s |\n\n", "      1. View Profile");
            System.out.format("     | %-38s |\n\n", "      2. Enter the values");
            System.out.format("     | %-38s |\n\n", "      3. Back");
			System.out.print("       -------------------------------------- \n\n");
			System.out.print("Enter your choice (1-3): ");
			try{
			int userChoose = input.nextInt();
			switch(userChoose){
			case 1:
				 memberObj.displayPersonalInfo();
				 userDataMenu();
				 break;
			case 2:
				System.out.println("Enter the user's electricity usage for the current month.");
				inputValues = input.nextInt();
				accountObject.addDetaisTOMember(this);
				userDataMenu();
				break;
			case 3:
				 break;
			default:
				 System.out.println("\u001B[31m  Invalid input.\u001B[0m\n\n");
				 userDataMenu();
				 break;
				}
		}
		catch(Exception e){
			 	 System.out.println("\u001B[31m  Invalid input.\u001B[0m\n\n");
				 userDataMenu();
		}
	}
	

	}

class EBMembers{
	int userIndexNo ;
	String[] userDetailsInput ;
	void checkUser(electricBill obj ){
		 String[][] userInfo = obj.userDetails;
		 String[] userNameList = new String[userInfo.length];
		 String[][] inputCheck = new String[userInfo.length][4];
		 int count = 0;
		 for(String[] values:userInfo){
			String personDetails= values[0];
			 inputCheck[count] = values[1].split(",");
			 userNameList[count] = (personDetails).toLowerCase();
           		 count++;				
		}
		
		userIndexNo = Arrays.asList(userNameList).indexOf((obj.userName).toLowerCase());
		int accountNumber = obj.userNumber;
		if((userIndexNo > -1)&&((accountNumber+"").equals(inputCheck[userIndexNo][2].trim()))){
			userDetailsInput = userInfo[userIndexNo];
			obj.memberMenuList();
		}
		else{
			System.out.println("\u001B[31m Invalid input.\u001B[0m\n\n");
			obj.memberRepeateValues();
			
		}
	}

	void displayPersonalInfo(){
			String[] userPersonDetails = this.userDetailsInput[1].split(",");
			System.out.print(" 		Personal Details\n");
			System.out.print(" ---------------------------------------------- \n\n");
			System.out.printf("| %-20s | %-20s |\n\n", "  User ID ", "    "+userDetailsInput[0]);
       		System.out.printf("| %-20s | %-20s |\n\n", "  User name ", "    "+userPersonDetails[0]);
        	System.out.printf("| %-20s | %-20s |\n\n", "  Account number ","    "+userPersonDetails[2]);
        	System.out.printf("| %-20s | %-20s |\n\n", "  Place ", "    "+userPersonDetails[1]);
        	System.out.print(" ---------------------------------------------- \n\n");
	}
	String[] userAccountDetails;
	int count;
	void displayDetails(){
		displayPersonalInfo();
		try{
		 userAccountDetails = this.userDetailsInput[2].split(","); 
		 count= 1; 
					String[] givenMonth = userAccountDetails[0].split("\\+");
					int value = Integer.parseInt(givenMonth[0].trim());
					System.out.println("		__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __  \n\n");
					System.out.printf("		| %-6s %-30s %-18s  %-20s  |\n\n", "S.No", "Current consumed(units)", "Total Amount", "Status");
			for(String monthDetails:userAccountDetails){
					givenMonth = monthDetails.split("\\+");
					value = Integer.parseInt(givenMonth[0].trim());
					String status;
					if(givenMonth[1].equals("pending")){
						status = "\u001B[31m"+givenMonth[1]+"\u001B[0m";
					}
					else{
						status = "\u001B[32m"+givenMonth[1]+"\u001B[0m";
					}
       				System.out.printf("		| %-6s %-30s %-18s  %-30s |\n\n", count, givenMonth[0], electricBill.amountCalculation(Integer.parseInt(givenMonth[0].trim())), status);

					count++;
			}
			System.out.println("		__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __  \n\n");
	}
		catch(Exception e){
			
			if(count == 1){
				System.out.println(" \u001B[31m No previous data or history found for this user.\u001B[0m\n");
			}
			else{
				System.out.println("		__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __  \n\n");
			}
		}
	}

	double payPendingBill(){
		double totalAmount = 0;
		try{
			userAccountDetails = this.userDetailsInput[2].split(",");
			int count = 0;
			for(int i=0;i<userAccountDetails.length;i++){
					String[] givenMonth = userAccountDetails[i].split("\\+");
					if(givenMonth[1].equals("pending")){
							count++;
							System.out.println("Unit consumed "+ givenMonth[0]);
							totalAmount += electricBill.amountCalculation(Integer.parseInt(givenMonth[0].trim()));
							System.out.println("Amount "+ electricBill.amountCalculation(Integer.parseInt(givenMonth[0].trim())));
					}
					else{
							
							break;
					}
			}	
			
			if(count==0){
				System.out.println("\u001B[32mThe bill has already been paid.\u001B[0m\n");
			}
		}
		catch(Exception e){
			System.out.println("\n\u001B[31m No payment history found.\u001B[0m\n");
		}
		return totalAmount;
	}

	void paymentInput(double userInputForPayment,electricBill obj){
		Scanner input = new Scanner(System.in);
		if( userInputForPayment == 1){
			 System.out.print("Enter credit card number: ");
			String userNameCheck = input.nextLine();
			 System.out.print("Enter expiration date: ");
			String userNumberCheck = input.nextLine();
			billTheAmount();
		}
		else{
			obj.memberMenuList();
		}
		
	}

	void printBill(String userName, String transactionId, double transactionAmount){
		 LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("           -----------------------------------------------------------------------");
        System.out.println("           |                         Payment  Receipt                            |");
        System.out.println("           -----------------------------------------------------------------------");
        System.out.println();
        System.out.printf("           |%70s\n\n", "Date : "+currentDateTime.format(formatter)+"     |");
         // System.out.printf("      |%72s%n", "Date: " + currentDateTime.format(formatter) + "   |\n");
	    System.out.printf("           | Name: %10s%51s%n", userName, "|\n");
	    System.out.printf("           | User ID: %-20s%42s %n", transactionId, "|\n");
	    System.out.printf("           | Amount: $%.2f%56s %n", transactionAmount, "|\n");
	    System.out.printf("            -----------------------------------------------------------------------\n\n");
	}

	void billTheAmount(){
		String[] userPersonDetails = this.userDetailsInput[1].split(",");
		userAccountDetails = this.userDetailsInput[2].split(",");
		double Amount = payPendingBill();
			printBill(userPersonDetails[0],userDetailsInput[0],Amount);
		
					System.out.println("\u001B[32mYour payment has been completed successfully. Have a great day.\u001B[0m");

					for(int i=0;i<userAccountDetails.length;i++){
					String[] givenMonth = userAccountDetails[i].split("\\+");
						if(givenMonth[1].equals("pending")){
							givenMonth[1] = "paid";
						}
						else{
								break;
						}
						userAccountDetails[i] = String.join("+",givenMonth);
			}
			userDetailsInput[2] = String.join(",",userAccountDetails);

			}
	

	static String rightAlign(String s,int width) {
        //int width = width; 
        int padSize = width - s.length();
        return String.format("%" + padSize + "s", s);
    }
    static String centerAlign(String s,int width) {
        //int width = 15;
        int padSize = width - s.length();
        int padStart = s.length() + padSize / 2;
        return String.format("%-" + padStart + "s", s);
    }

}



class EBAccount{
	 static int counter = 1;
	 void totalUser(int totalNumberOfPerson){
	 	counter = totalNumberOfPerson+1;
	 }
	 public static String generateId() {
        return "ZSEBMID" + counter++;
    }

	void userCheck(String name, int numberValues,electricBill obj){
			
			if(((name.toLowerCase()).equals(accountCreater[0].toLowerCase()))&&((numberValues+"").equals(accountCreater[2]))){
				obj.accountMenuList();
			}
			else{
				System.out.println("\u001B[31m Invalid User Id & Password. \u001B[0m \n\n");
				obj.inputUserGet(false);
			}
	} 
	String[] accountCreater = {"ZSEBM001","Gopika","254","Manage Details"};
		void displayInfo(){
			System.out.println("--------- 	Admin Profile	 --------");
			System.out.print(" ---------------------------------------------- \n\n");
			System.out.printf("| %-20s | %-20s |\n", "  User ID ", "    "+accountCreater[0]);
       		System.out.printf("| %-20s | %-20s |\n", "  Admin name ", "    "+accountCreater[1]);
        	System.out.printf("| %-20s | %-20s |\n", "  Account number ","    "+accountCreater[2]);
        	System.out.printf("| %-20s | %-20s |\n", "  Role ", "    "+accountCreater[3]);
        	System.out.print(" ---------------------------------------------- \n\n");
		}
		String[] newUserDetails ;
		Scanner input = new Scanner(System.in);
	void addDataToMember(electricBill obj,EBMembers obj1){
			obj.getMemberValueFromText();
			System.out.print("Do you want to List the members ? Yes (1) or no (2)  ");
			switch(input.nextInt()){
			   case 1: 
			   		viewTheMembersList(obj);
			   		break;
			   default:
			   		memberDetailsAdd(obj,false);
			   		break;
			}
			
	}

	void newUserIntoFile(electricBill obj1){
		try{
			obj1.lines = Files.readAllLines(obj1.filePath);
			Files.write(obj1.filePath, "".getBytes());
				for (String line : obj1.lines) {
					Files.write(obj1.filePath, (line + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
				}
			totalUser((obj1.lines).size());
			String newId = generateId();
			 System.out.println("           -------------------------------------------------------------");
		    System.out.println("           |                        Account details                     |");
		    System.out.println("           --------------------------------------------------------------");
		    System.out.printf("           | %-58s |\n" , " ");
		    System.out.printf("           | %-58s |\n" , "              User Id:  ZSEBMID"+(counter-1));
		    System.out.printf("           | %-58s |\n" , " ");
		    System.out.println("           --------------------------------------------------------------");
			newUserDetails = new String[]{newId, obj1.userName,obj1.placeName, obj1.accountNumber+""};
			System.out.println("\u001B[32m Account created successfully \u001B[0m");
			String newAccountDetails = newUserDetails[0]+"-"+newUserDetails[1]+","+newUserDetails[2]+","+newUserDetails[3]+"- ";
			Files.write(obj1.filePath,newAccountDetails.getBytes(),StandardOpenOption.APPEND);
		}
		catch(Exception e){
			System.out.println("hi");
		}
	}
	String[] userNameList ;

	void viewTheMembersList(electricBill obj){
		
        userNameList = new String[obj.userDetails.length];
        try{
         System.out.println("\n\n______________________________________________________________________\n");
         System.out.printf("%-8s%-15s%-20s%-15s%-20s\n", "S.no", "Id", "Name", "EB no.", "Place");
         System.out.println("______________________________________________________________________\n");
         int count = 1;
         for(String[] member:obj.userDetails){
         	String[] memeberInfo = member[1].split(",");
         	userNameList[count-1] = member[0];
         	System.out.printf("%-8d%-15s%-20s%-15s%-20s\n", count, member[0], memeberInfo[0],  memeberInfo[2],  memeberInfo[1]);
         	 System.out.println("______________________________________________________________________\n");
         	count++;
         }
         

     }
     catch(Exception e){

     }
     	memberDetailsAdd(obj,false);
	} 
	int userIndex;
	void memberDetailsAdd(electricBill obj,boolean answer){
		System.out.println("\n\nEnter the user id");
		if(answer !=true){
			input.nextLine();
		}
		String userName = input.nextLine();
		userIndex =  Arrays.asList(userNameList).indexOf(userName.toUpperCase());
		if(userIndex>-1){
				setUserToMember(obj);
				obj.userDataMenu();
		}
		else{
			System.out.println("\u001B[31mInvalid user\u001B[0m");
			memberDetailsAdd(obj,true);
		}
	}

	void setUserToMember(electricBill obj){
		obj.memberObj.userDetailsInput = obj.userDetails[userIndex];
	}

	void addDetaisTOMember(electricBill obj1){
		if(obj1.inputValues<=100){
			obj1.memberObj.userDetailsInput[2] = obj1.inputValues+"+paid,"+obj1.memberObj.userDetailsInput[2];
		}
		else{
			obj1.memberObj.userDetailsInput[2] = obj1.inputValues+"+pending,"+obj1.memberObj.userDetailsInput[2];
		}
		obj1.userDetails[userIndex] = obj1.memberObj.userDetailsInput;
		String[] individualArray = new String[obj1.lines.size()];
        int count = 0;
        for (String[] userValues : obj1.userDetails) {
            individualArray[count] = String.join("-", userValues);
            count++;
        }
        try {
              String modifiecString = String.join("", individualArray);
              Files.write(obj1.filePath, "".getBytes());
               for (String element : individualArray) {
                Files.write(obj1.filePath, (element + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
              }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
	}


}
 