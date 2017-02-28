import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;



public class Problem8 {

	public static void main(String[] args) {
   
          
	    List<Character> powers= Arrays.asList('2','3','4','5','6','7','8','9','1','J','Q','K','A');
		List<Character> suits=Arrays.asList('C','D','H','S');
		  
          Scanner sc=new Scanner(System.in);
         LinkedHashMap<String,HashSet<String>> handMap=new LinkedHashMap<>();
          
          while(true){
        	  String[] input=sc.nextLine().trim().split(": ");
        	  if(input[0].equals("JOKER")){
        		  break;
        	  }
        	  String name=input[0];
        	  String[] hand=input[1].split(", ");
        	  if(!handMap.containsKey(name)){
        		  handMap.put(name,new HashSet<>());
        	  }
        	  for(int i=0;i<hand.length;i++){
        		  handMap.get(name).add(hand[i]);
        	  }
          }
          
          for(String name: handMap.keySet()){
        	  System.out.printf("%s: ",name);
        	  HashSet<String> currHand=handMap.get(name);
        	  int handSize=0;
        	  for (String card : currHand) {
        		  int power=powers.indexOf(card.charAt(0)) +2;
        		  int suit=suits.indexOf(card.charAt(card.length()-1))+1;
        		  handSize+=power*suit;
				
			}
        	  System.out.println(handSize);
          }

	}

}
