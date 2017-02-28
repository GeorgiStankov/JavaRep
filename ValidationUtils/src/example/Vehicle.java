package example;

public class Vehicle implements Validatable{
String registrationNumber;
String brand;

Vehicle(String registration,String brand){
	this.registrationNumber=registrationNumber;
	this.brand=brand;
	
}
@Override
public boolean isValid() {
	// TODO Auto-generated method stub
	return false;
}

}
