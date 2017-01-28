package week02;

import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[14][14];
		int[][] arr2 = new int[14][14];
		int n = sc.nextInt();

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 14; j++) {
				arr2[i][j] = 0;
			}

		}
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] pair = sc.nextLine().split(" ");

			int x = Integer.parseInt(pair[0]);
			int y = Integer.parseInt(pair[1]);
			arr2[x][y] = 1;
		}
		sc.close();

		while (true) {
			
			for (int i = 0; i < arr2.length; i++) {
                for (int j = 0; j < arr2[i].length; j++) {
                  arr[i][j] = arr2[i][j];
                }
            }
			printing(arr);
			Thread.sleep(1000);
			for (int row = 0; row < arr.length; row++) {
				for (int col= 0; col < arr[row].length; col++) {

					if (arr[row][col] == 1 && !(count(arr, row, col) == 2 || count(arr, row, col) == 3)) {
                        arr2[row][col] = 0;
                    }
                    else if    (arr[row][col] == 0 && count(arr, row, col) == 3) {
                        arr2[row][col] = 1;
                    }
				}
			}

		}

	}


	

	public static int count(int[][] board, int a, int b) {
		int count = 0;
		int[][] surrounding = { { a - 1, b - 1 }, { a - 1, b }, { a - 1, b + 1 }, { a, b - 1 }, { a, b + 1 },
				{ a + 1, b - 1 }, { a + 1, b }, { a + 1, b + 1 } };
		for (int i[] : surrounding) {
			try {
				if (board[i[0]][i[1]] == 1) {
					count++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return count;
	}
	public static void printing(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if(array[i][j]==1){
					System.out.print("■ ");
				}
				else System.out.print("□ ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
