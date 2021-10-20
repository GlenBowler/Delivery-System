

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class QuickFood{
	
	//Main
	public static void main(String[] args) {
		//Accessing my customer details
		Customer newCustomer=CustomerDetails();
		//Accessing my resturant details
		Resturant BurgerJoint=createResturant();
		//Customer adress
		String customerAdress=newCustomer.getCustomerAdress();
		//Customer Location
		String customerLocation=newCustomer.getCustomerCity();
		//Resturant location
		String resturantLocation=BurgerJoint.getLocationOfResturant();
		//Creating a set with all the cities in country where my resturant is
		Set<String> cities=new HashSet<String>();
		cities.add("Cape Town");
		cities.add("Durban");
		cities.add("Johannesburg");
		cities.add("Potchefstroom");
		cities.add("Springbok");
		cities.add("Bloemfontein");
		cities.add("Port Elizabeth");
		cities.add("Witbank");
		
	if(cities.contains(customerLocation)) {
		try {
			//Getting driver list
			File myDrivers=new File("C:\\drivers.txt");
			Scanner readDriver=new Scanner(myDrivers);
			//Customer Locaiton
			//Array to store all valid drivers inside
			ArrayList<String> validDrivers=new ArrayList<>();
			
			//While the text file of drivers got a next Line we will run this loop to store drivers in arr
			while(readDriver.hasNextLine()) {
				//read line from driver text file
				String fileInput=readDriver.nextLine();
				//Splitting driver details up in 3 part arr
				String[] driverList=fileInput.split(", ");
				
				//if statement to see what driver is going to be stored as valid driver 
				if(driverList[1].equals(customerLocation)) {
					validDrivers.add(fileInput);
				}
			}
			
			int lowestAmount=1000;//making it large number since know no one would have more than 1000 d
			String driverToDoLoad = null;
			//For loop that will determine the driver with the least loads of all your drivers
			for(int j=0;j<validDrivers.size();j++) {
				//Getting the first driver that we want to compare and split with ,
				String[] driver=validDrivers.get(j).split(", ");
				//Getting driver amount of loads that he/she is busy with 
				int driverAmountOfLoads=Integer.parseInt(driver[2]);
				//for loop to check other drivers in valid drivers and compare to first driver
				if(driverAmountOfLoads<lowestAmount) {
					//Assigning the new lowestValue
					lowestAmount=driverAmountOfLoads;
					//Saving driver name with lowest trips
					driverToDoLoad=validDrivers.get(j);
				}
			}
			
			//Saving the driver to do load inside array so can only get the driver name
			String[] driverArray=driverToDoLoad.split(", ");
			//Getting driver name
			String driverName=driverArray[0];
			//Assigning the new driver to my class
			Driver myDriver=new Driver(driverName,customerAdress);
	  }
		
		//catch exception for if the drivers.txt file is not found
		catch (FileNotFoundException e) {
			System.out.println("Error");
			}
		
		try {
			PrintWriter writer=new PrintWriter("invoice.txt","UTF-8");
			writer.write(newCustomer.displayCustomer());
			writer.write(BurgerJointMenu());
			writer.write(Driver.displayDriver());
			writer.write(createResturant().displayResturant());
			writer.close();
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		//if cutomer location and resturant location does not equal each other return this message
		else {
			try {//Write to invoice if we dont have someone there
				PrintWriter writer=new PrintWriter("invoice.txt","UTF-8");
				writer.write("Sorry! Our drivers are to far away from you to be able to deliver to your location");
				writer.close();
		}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Creating a resturant
	public static Resturant createResturant() {
		//Assigning valaus to my new Resturant
		String name="Burger Joint";
		String resturantLocation="Cape Town";
		String number="072 222 4897";
		Resturant BurgerJoint=new Resturant(name,resturantLocation,number);
		return BurgerJoint;
	}
	
	//Function to get user order
	public static String BurgerJointMenu(){
		//Prices for burgers
		int singeCheesePrice=48;
		int doubleCheesePrice=79;
		int megaCheesPrice=100;
		
		//Counter to check how much of each item user ordered
		int countSingle=0;
		int countDouble=0;
		int countMega=0;
		
		//Total prices
		int totalSingle=0;
		int totalDouble=0;
		int totalMega=0;
		int totalPrice=0;
		//Asking user what he want
		Scanner input=new Scanner(System.in);
		Scanner specail=new Scanner(System.in);
		int myChoice =1;
		
		do {
			System.out.println("Please enter the number you want to order:"
					+ "\n 1:Single Cheese Burger (R48.00)"
					+ "\n 2:Double cheese burger (R79.00)"
					+ "\n 3:Mega cheese burger (R100.00)"
					+ "\n 4:I am done ordering");
			myChoice=input.nextInt();
			
			if(myChoice ==1) {
				countSingle++;
			}
			else if(myChoice ==2) {
				countDouble++;
			}
			else if(myChoice ==3) {
				countMega++;
			}
		}
		
		while (myChoice!=4) ;
			//Specail instructions
			System.out.println("Is there any specail instructions you want to add");
			String specailInstructions=specail.nextLine();
			//Calculation for the user total order
			totalSingle=countSingle*singeCheesePrice;
			totalDouble=countDouble*doubleCheesePrice;
			totalMega=countMega*megaCheesPrice;
			totalPrice=totalSingle+totalDouble+totalMega;
			//Return value that we will store on file
			String myOrder="Your oder is as follow:"
			+"\n\n"+countSingle+"X"+" Single Cheese burger"+"(R"+totalSingle+")"
			+"\n"+countDouble+"X"+" Double Cheese burger"+"(R"+totalDouble+")"
			+"\n"+countMega+"X"+" Mega Cheese burger"+"(R"+totalMega+")"
			+ "\n\nSpecial Instructions:"+specailInstructions
			+"\n\nTotal: R"+totalPrice+"\n\n";
		
		return myOrder;
}

	//Geting the user info
	public static Customer CustomerDetails() {
		Scanner input=new Scanner(System.in);
		//Order number
		int [] orderNum=new int[4];
		int max=10;
		int min=1;
		for (int i=0;i<orderNum.length;i++) {//Generating random valuse for your order number
			orderNum[i]=(int) (Math.random()*((max-min+1)+min));
			}
		String customerOrderNumber=Integer.toString(orderNum[0])+Integer.toString(orderNum[1])+Integer.toString(orderNum[2])+Integer.toString(orderNum[3]);//Concacting the integers to string
		//Name
			System.out.println("Please enter your name");
			String customerName=input.nextLine();
		//Surname
			System.out.println("Please enter your surname");
			String customerSurname=input.nextLine();
		//Fullname
			String customerFullName=customerName+" "+customerSurname;	
		//Email adress
			System.out.println("Please enter your email address");
			String customerEmail=input.nextLine();
		//Phone number
			System.out.println("Please enter your phone number");
			String customerPhoneNumber=input.nextLine();
		//Location
			System.out.println("Please enter your city your live in");
			String customerLocation=input.nextLine();
		//Adress
			System.out.println("Please enter your adress");
			String customerAdress=input.nextLine();
			
		//Customer newCustomer=new Customer(customerOrderNumber,customerFullName,customerEmail,customerPhoneNumber,customerLocation);
		Customer newCustomer=new Customer(customerOrderNumber,customerFullName,customerEmail,customerPhoneNumber,customerLocation,customerAdress);	
		return newCustomer;
		}

}
