package week2;

public class EqualConsecutiveElements {

	public static void main(String[] args) {
		
		int[] items={1,2,3,4,4,4,4,4,4,5,6,6,6,6,6,6,6,6,5,5,5,5};
        System.out.println(cosecutiveElements(items));
	}

	public static  int cosecutiveElements(int[] a){
		int count=0,count1=0;
		for(int i=1;i<a.length;i++){
			if(a[i]==a[i-1]){
				count++;
			}
			else{
				if(count1<count){
				count1=count;
				}
				count=0;
				count++;
			}
		}
		if(count>count1){
		return count;
		}
		else return count1;
	
	}
}
