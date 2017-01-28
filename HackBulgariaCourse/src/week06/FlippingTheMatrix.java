package week06;

import java.util.Scanner;

public class FlippingTheMatrix {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int q = sc.nextInt();
		int n = sc.nextInt();
		int[][] matrix = new int[2 * n][2 * n];
		sc.nextLine();
		for (int i = 0; i < q; i++) {
			matrix = input(n);
			check(matrix);
			check(matrix);
			check(matrix);

		}
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				// System.out.println("enter the elementss for the Matrix");
				System.out.print(matrix[row][col]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] input(int n) {

		int[][] matrx = new int[2 * n][2 * n];
		for (int row = 0; row < matrx.length; row++) {
			for (int col = 0; col < matrx[row].length; col++) {
				// System.out.println("enter the elementss for the Matrix");
				matrx[row][col] = sc.nextInt();
			}
			System.out.println();
		}
		return matrx;

	}

	public static boolean check(int[][] matrix) {
		int n = matrix.length / 2;

		for (int col = 0; col < n*2; col++) {
			int left = 0;
			int right = 0;
			for (int row = 0; row < n*2; row++) {
				if (col < n) {
					left += matrix[row][col];
				} else {
					right += matrix[row][col];
				}
			}

			if (left < right) {
				matrix = reverseCol(matrix,col);
			}

		}

		for (int row = 0; row < n; row++) {
			int left = 0;
			int right = 0;
			for (int col = 0; col < n*2; col++) {
				if (col < n) {
					left += matrix[row][col];
				} else {
					right += matrix[row][col];
				}
			}

			if (left < right) {
				matrix = reverseRow(matrix,row);
			}

		}
		
		
		return true;
	}

	public static int[][] reverseRow(int[][] mat,int row) {
		
		
		
			for (int j = 0; j < mat.length/2; j++) {
				int temp = mat[row][j];
			    mat[row][j] = mat[row][mat.length - j - 1];
			    mat[row][mat.length - j - 1] = temp;	
			}
		    
		

		return mat;
	}
	public static int[][] reverseCol(int[][] mat,int col) {
		
		
		
		for (int j = 0; j < mat.length/2; j++) {
			int temp = mat[j][col];
		    mat[j][col] = mat[mat.length - j - 1][col];
		    mat[mat.length - j - 1][col] = temp;	
		}
	    
	

	return mat;
}

}
