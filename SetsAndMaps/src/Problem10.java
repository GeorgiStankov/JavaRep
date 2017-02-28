import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem10 {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<String, LinkedHashMap<String, Integer>>();
		LinkedHashMap<String, Integer> innerMap = new LinkedHashMap<String, Integer>();

		
        while(true){
        	String input=sc.nextLine();
        	if(input.equals("report")){
        		break;
        	}
        	String[] str=input.split("|");
        	String city=str[0];
        	String country=str[1];
        	int population=Integer.parseInt(str[2]);
        	
        	if(map.containsKey(country)){
        		 
        		
				innerMap.put(city+": "+population,innerMap.get(city)+population);
				map.put(country,innerMap);
        	}
        	else{
				
				innerMap = new LinkedHashMap<String,Integer>();
       		 innerMap.put(city, population);
       		 map.put(country, innerMap);
				}
        }
	}

}


//package SetsMaps;
//
//
//import java.math.BigInteger;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ten {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        HashMap<String, LinkedHashMap<String, BigInteger>> map = new HashMap<>();
//        LinkedHashMap<String, BigInteger> map2 = new LinkedHashMap<>();
//        while (!input.equals("report")) {
//            String[] inputTokens = input.split("\\|");
//            String country = inputTokens[1];
//            String city = inputTokens[0];
//            String population = inputTokens[2];
//            if (!map.containsKey(country)) {
//                LinkedHashMap<String, BigInteger> map1 = new LinkedHashMap<>();
//                map.put(country, map1);
//                map.get(country).put(city, new BigInteger(population));
//                map2.put(country, BigInteger.ZERO);
//            }
//            map2.put(country, map2.get(country).add(new BigInteger(population)));
//            map.get(country).put(city, new BigInteger(population));
//            input = scanner.nextLine();
//        }
//        map2.entrySet().stream().sorted((k, k1) -> (k1.getValue().compareTo(k.getValue())))
//                .forEach(asd -> {
//                    String name = asd.getKey();
//                    LinkedHashMap<String, BigInteger> d = map.get(name);
//                    System.out.printf("%s (total population: %d)\n", name, asd.getValue());
//
//                    d.entrySet().stream().sorted((c, c1) -> (c1.getValue().compareTo(c.getValue()))).forEach(asd1 -> {
//                        System.out.printf("=>%s: %s\n", asd1.getKey(), asd1.getValue());
//                    });
//
//                });
//
//
//    }
//}
