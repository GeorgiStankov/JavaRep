package week06;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SelectingSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 7, 8, 5, 4, 3, 1, 10, 15, 12 };
		List<Integer> list = new ArrayList<>(Arrays.asList(7, 8, 5, 4, 3, 1, -1, 15, 12));
		 select(arr);
		// bubble(arr);
		// insert(arr);
		count(list);
		System.out.println(list);
		// System.out.println(Arrays.toString(arr));

	}

	public static void select(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			int pos = i;
			for (int j = i + 1; j < arr.length - 1; j++) {

				if (arr[pos] > arr[j]) {
					pos = j;
				}
				if (pos != i) {
					int swap = arr[i];
					arr[i] = arr[pos];
					arr[pos] = swap;
				}
			}

		}
	}

	public static void insert(int[] arr) {
		for (int i = 1; i <= arr.length - 1; i++) {
			int d = i;
			while (d > 0 && arr[d] < arr[d - 1]) {
				int temp = arr[d];
				arr[d] = arr[d - 1];
				arr[d - 1] = temp;
				d--;
			}

		}
	}

	public static void bubble(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
		}
	}

	public static void count(List<Integer> list) {
		int min = Collections.min(list);
		int max = Collections.max(list);
		int k = max - min + 1;
		int[] histo = new int[k];		
		for (int i = 0; i < list.size(); i++) {
			histo[list.get(i)-min]++;
		}
		list.clear();
		for (int i = 0; i < histo.length; i++) {
			if (histo[i] != 0) {
				for (int j = 0; j < histo[i]; j++) {
					list.add(i +min );
				}
			}
		}
	}

}
