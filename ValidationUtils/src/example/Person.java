package example;

public class Person implements Validatable {
private String firstName;
private String mobileNumber;
private String email;
Person(String firstName,String mobileNumber,String email){
	this.firstName=firstName;
	this.mobileNumber=mobileNumber;
	this.email=email;
}
public String getFirstName(){
	return firstName;
}
public String getMobileNumber(){
	return mobileNumber;
}
public String getEmail(){
	return email;
}
public void setFirstName(String firstName){
	this.firstName=firstName;
}
public void setMobileNumber(String mobileNumber){
	this.mobileNumber=mobileNumber;
}
public void setEmail(String email){
	this.email=email;
}
@Override
public boolean isValid() {
	return true;
}


}
