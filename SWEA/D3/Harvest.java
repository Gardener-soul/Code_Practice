package D3_Harvest;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase <= T; testCase++) {
			int N = scanner.nextInt();
			char[][] farm = new char[N][N];
			int sum = 0;

			for(int i=0; i<N; i++) {
				farm[i] = scanner.next().toCharArray();
			} //
			
			int mid = N/2; // 2
			int a = 0;
			
			for(int r = 0; r<=mid; r++) {
				for(int c=mid-a; c<=mid+a; c++) {
					sum+=farm[r][c] - '0';
				}
				a++;
			}
			a--;
		
			for(int r=mid+1; r<N; r++) {
				--a;
				for(int c=mid-a; c<=mid+a; c++) {
					sum+=farm[r][c] - '0';
				}
			}
			
			System.out.println("#" + testCase + " " + sum);
			
		}
		
	}
	
}
