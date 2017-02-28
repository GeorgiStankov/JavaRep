package week2;

public class LucasSeries {

	public static void main(String[] args) {
		
        System.out.println(lucasSer(6));
	}
	
	public static int  lucasSer(int a){
		
		int c=0;
		int first=2;int second=1;
		
		for(int i=0;i<a-1;i++){
			//System.out.printf("%d",c);
			c=first+second;
			first=second;
			second=c;
						
		}
		return c;
	}
	
}