
import java.util.Scanner;

public class BMICalculator {
	
	public static void printIntroduction() 
	{
			}
	public static void getStatus(double g){
		
		if(g<=18.5)
		{
			System.out.println("underweight");
		}
		if (g>=18.5 && g<=25)
		{
			System.out.println("normal");	
		}
		if(g>=25 && g<=30)
		{
			System.out.println("overweight");	
		}
		else{
			System.out.println("obese");
		}
		
		
		
	}
	public static void getBMI(Scanner n,Scanner v){
		System.out.println("enter");
		double i=n.nextDouble();
		System.out.println("enter");
		double s=v.nextDouble();
		double weight=i*(2.2046);
		double height=s*(2.54);
		System.out.println("your weight in lbs is:"+ weight);
		System.out.println("your height in inches is:"+ height);
		double g=bmiFor(weight,height);
		
	 System.out.println(g);	
	 getStatus(g);
	 }
	
	public static double bmiFor(double weight,double height){
		
		double bodymass=(weight/((height*2.703)*(height*2.703)));
		return bodymass;
	}

	public static void main(String[] args) {
	
		Scanner n=new Scanner(System.in);
		
		Scanner v=new Scanner(System.in);
		getBMI(n,v);
		
		
	}

}
