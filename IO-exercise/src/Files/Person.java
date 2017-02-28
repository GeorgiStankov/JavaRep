package Files;

public class Person {
private String firstName;
private String lastName;
private String EGN;
private String address;
private String university;
public Person (String firstName, String lastName, String EGN, String address, String university){
	this.firstName=firstName;
	this.lastName=lastName;
	this.EGN=EGN;
	this.address=address;
	this.university=university;
}
public String getAddress() {
	return address;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getEGN() {
	return EGN;
}
public String getUniversity() {
	return university;
}


}
