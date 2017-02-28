package week2;

public class IncreaseDecreaseSeque {

	public static void main(String[] args) {
		
		int sequence[]={1,2,2,3,1};
		System.out.println(isDecreaseing(sequence));
	}

	public static boolean   isDecreaseing(int seq[]){
		for(int i=0;i<seq.length-1;i++){
			if(seq[i]>seq[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static boolean   isIncreaseing(int seq[]){
		for(int i=0;i<seq.length-1;i++){
			if(seq[i]<seq[i+1]){
				return false;
			}
		}
		return true;
	}
}
