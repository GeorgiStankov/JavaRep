package week1;

public class DecodeURL {

	public static void main(String[] args) {
		String input="kitten%20pic.jpg";
	 System.out.println(decode(input));	

	}
	public static String decode(String in){
		
		in.replace("%20"," ");
		in.replace("%3A",".");
		in.replace("%3D","?");
		in.replace(" %2F","/");
		return in;
	}

}
