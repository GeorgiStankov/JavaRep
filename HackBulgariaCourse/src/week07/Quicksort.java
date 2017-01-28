package week07;

public class Quicksort {

	public static void main(String[] args) {
	
	}
	
	void quicksort(int[] arr,int left,int right){
		
		int index=partition(arr,left,right);
		if(left<index-1){
			quicksort(arr, left, index-1);
		}
		if(index<right){
			quicksort(arr, index, right);
		}
		
	}
	
	public int partition(int[] arr,int left,int right){
		
		int i=left;
		int j=right;
		int mid=arr[(left+right)/2];
		int temp;
		while(i<=j){
			while(arr[i]<mid) i++;
			while(arr[j]>mid) j--;
			if(i<=j){
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		};
		
		return i;
	}

}
