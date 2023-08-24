import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.nextLine();
		for(int testCase = 1; testCase<=N; testCase++) {
			
			char[][] sero = new char[5][15];
			
			for(int i=0; i<5; i++) {
				sero[i] = scanner.next().toCharArray();
			}
			
			int rmax=-1;
			for(int i=0; i<5; i++) {
				if(rmax < sero[i].length) {
					rmax = sero[i].length;
				}
			}
			
			System.out.print("#" + testCase + " ");
			for(int c=0; c<rmax; c++) {
				for(int r=0; r< 5; r++) {
					if(sero[r].length <= c) {
						continue;
					}
					System.out.print(sero[r][c]);
				}
			}
			System.out.println();
		} //tc
	}
}