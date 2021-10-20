
public class Customer {
	//Attributes
	String customerOrderNumber;
	String customerName;
	String customerSurname;
	String customerFullname;
	String customerEmail;
	String customerPhoneNum;
	String customerCity;
	String customerAdress;

	//Getters for customer
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public String getCustomerFullname() {
		return customerFullname;
	}
	public String getCustomerPhoneNum() {
		return customerPhoneNum;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public String getCustomerAdress() {
		return customerAdress;
	}

	//Creating customer method
	public Customer(String customerOrderNumber,String customerFullName,String customerEmail,String customerPhoneNum,String customerCity,String customerAdress) {
		this.customerOrderNumber=customerOrderNumber;
		this.customerFullname=customerFullName;
		this.customerEmail=customerEmail;
		this.customerPhoneNum=customerPhoneNum;
		this.customerCity=customerCity;
		this.customerAdress=customerAdress;
	}

	public String displayCustomer() {//method to display customer details
		String output="Order number: "+customerOrderNumber;
		output+="\nCustomer name: "+customerFullname;
		output+="\nEmail adress: "+customerEmail;
		output+="\nPhone number: "+customerPhoneNum;
		output+="\nLocation: "+customerCity+"\n\n";
		return output;
	}
}
