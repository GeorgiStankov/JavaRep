package week1;

public class PrimeNumber {

	public static void main(String[] args) {
		
System.out.print(isPrime(15));
	}
public static boolean isPrime(int num){
	boolean isPrime=true;
	int temp;
	for(int i=2;i<=num/2;i++)
	{
		  System.out.println(i);
           temp=num%i;
         
	   if(temp==0)
	   {
	      isPrime=false;
	      break;
	   }
	}
	//If isPrime is true then the number is prime else not
	if(isPrime)
	  return true;
	else
	  return false;
}
}
