import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Pattern pat = Pattern.compile("(.+)-(.+)");
        HashMap<String,String > map = new HashMap<>();
        while(!(input = sc.nextLine()).equals("search")){
            Matcher matcher = pat.matcher(input);
            if(matcher.find()) {
                map.put(matcher.group(1), matcher.group(2));
            }
        }
        while(!(input= sc.nextLine()).equals("stop")){
            if(map.containsKey(input)){
                System.out.format("%s -> %s\n",input,map.get(input));
            }else{
                System.out.format("Contact %s does not exist.\n",input);
            }
        }
    }
}
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Problem5 {
//
//	public static void main(String[] args) {
//		HashMap<String, String> map = new HashMap<String, String>();
//		Scanner sc = new Scanner(System.in);
//		String temp = null;
//		;
//		while(!sc.next().equals("search")) {
//			temp = sc.next();            
//			String[] nameAndNum = temp.split("-");
//			map.put(nameAndNum[0], nameAndNum[1]);
//            
//		}
//		String searchName;
//		do {
//			searchName = sc.next();
//			if (map.containsKey(searchName)) {
//				System.out.println(searchName + " -> " + map.get(searchName));
//			} else {
//				System.out.println("Contact " + searchName + " does not exist.");
//			}
//		} while (!searchName.equals("stop"));
//
//	}
//
//}
