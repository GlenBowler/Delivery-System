
public class Resturant {
String name;
String locationOfResturant;
String numberOfResturant;

//Getters for resturant
public String getName() {
	return name;
}

public String getLocationOfResturant() {
	return locationOfResturant;
}

public String getNumberOfResturant() {
	return numberOfResturant;
}

//Constructor for restuarant
public Resturant(String name, String locationOfResturant, String numberOfResturant) {
	this.name = name;
	this.locationOfResturant = locationOfResturant;
	this.numberOfResturant = numberOfResturant;
}

//Display restaurant
public String displayResturant() {
	String output="\n\nIf you need to contact "+name+", their number is "+numberOfResturant+" .";
	return output; 
}


}
