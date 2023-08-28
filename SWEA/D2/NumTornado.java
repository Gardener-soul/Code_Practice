import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			int N = scanner.nextInt();
			int[][] num = new int [N][N];
			int[][] num90 = new int[N][N];
			int[][] num180 = new int[N][N];
			int[][] num270 = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					num[i][j] = scanner.nextInt();
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					num90[r][c] = num[N-1-c][r];
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					num180[r][c] = num[N-1-r][N-1-c];
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					num270[r][c] = num[c][N-1-r];
				}
			}
			
			System.out.println("#"+testCase);
			for(int r=0; r<N; r++) {
				
				for(int c=0; c<N; c++) {
					System.out.print(num90[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(num180[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(num270[r][c]);
				}
				System.out.println();
			}
		}
	}	
}
