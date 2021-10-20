
public class Driver {
	//Attribute for driver
static String driverName;
static String customerLocation;

//Getters for driver
public String getDriverName() {
	return driverName;
}
public String getCustomerLocation() {
	return customerLocation;
}

//Constructor for driver
public Driver(String driverName, String customerLocation) {
	this.driverName = driverName;
	this.customerLocation = customerLocation;
}

//Display method for driver
public static String displayDriver() {
	String output=driverName+" is the nearest to the restaurant and so he/she will be delevering your order to you at:";
	output+="\n\n"+customerLocation;
	return output;
}


}
