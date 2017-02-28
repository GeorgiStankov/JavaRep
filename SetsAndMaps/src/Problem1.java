import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			set.add(sc.next());
		}
		
		for(String c:set){
			System.out.println(c);
		}
	}

}
