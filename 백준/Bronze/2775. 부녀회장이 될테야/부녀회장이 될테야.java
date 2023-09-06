import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int[][] arr = new int[15][15];
		for(int i=0; i<15; i++) {
			arr[i][0] = 1;
			arr[0][i] = i+1;
		}
		
		for(int r=1; r<15; r++) {
			for(int c=1; c<15; c++) {
				arr[r][c] = arr[r-1][c] + arr[r][c-1];
			}
		}

		Scanner scanner = new Scanner (System.in);
		int T = scanner.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			
			System.out.println(arr[r][c-1]);
		}		
//		for(int r=0; r<14; r++) {
//			System.out.println();
//			for(int c=0; c<14; c++) {
//				System.out.print(arr[r][c] + " ");
//			}
//		}
	}
	
}