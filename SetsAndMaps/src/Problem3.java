import java.util.Scanner;
import java.util.TreeSet;

public class Problem3 {

	public static void main(String[] args) {
	TreeSet<String> set=new TreeSet<String>();
	Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    while(sc.hasNext()){
    	set.add(sc.next());
    }
    
//    for(int i=0;i<n;i++){
//    	set.add(sc.nextLine());
//    }
    for(String element:set){
    	System.out.print(element+" " );
    }
	
	
	sc.close();
	}

}
