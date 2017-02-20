package week1;

public class VowelsInString {

	public static void main(String[] args) {
				String a="ghjtrswe";
		System.out.println(countVowel(a));
		System.out.println(countConsonant(a));
	}
	
	public static int countConsonant(String str){
		String nstr=str.toLowerCase();
		char[] ch={'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};

		int occ=0;
		for(int i=0;i<nstr.length();i++){
			for(int s=0;s<ch.length;s++){
				if(nstr.charAt(i)==ch[s]){
					occ++;
				}
			}
			
		}
		
		return occ;
	}
	public static int countVowel(String str){
		String nstr=str.toLowerCase();
		int i=0 ;
		for(int s=0;s<nstr.length();s++){
			if(nstr.charAt(s)=='a' ||nstr.charAt(s)=='e' ||nstr.charAt(s)=='i' ||nstr.charAt(s)=='o' ||
					nstr.charAt(s)=='u' ||
					nstr.charAt(s)=='y'){
				i++;
			}
		}
		return i;
	}

}
