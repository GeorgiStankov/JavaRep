package DefineClassPerson;

 class Person  {
String name;
int age;
Person(){
	name="No name";
	age=1;
}
Person(int age){
	name="No name";
	this.age=age;
}
Person(String name,int years){
	this.name=name;
	this.age=years;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getYears() {
	return age;
}
public void setYears(int years) {
	this.age = years;
}
@Override
public String toString(){
	return String.format("%s %d",this.name,this.age);
}

//@Override
//public int compareTo(Person o) {
//	return 0;
//}
}
