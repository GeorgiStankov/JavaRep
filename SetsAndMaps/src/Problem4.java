import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;





public class Problem4 {

	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String[] symbol = null;
		
		
			symbol = sc.nextLine().split("");
		

       
		for (String alphabet : symbol) {
			int count=1;
			if (map.containsKey(alphabet)) {
			    count=map.get(alphabet)+1;
				map.put(alphabet,count);
			}
			else map.put(alphabet,count);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    String key = entry.getKey();
		    int value = entry.getValue();
		    System.out.println(key+": "+value+" time/s");
		}
		

	}

}
