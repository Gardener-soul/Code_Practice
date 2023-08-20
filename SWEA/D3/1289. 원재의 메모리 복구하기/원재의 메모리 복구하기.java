import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			char[] N = scanner.next().toCharArray(); //메모리의 원래 값.
			
			char tmp = '0';
			int cnt=0;
			for(int i=0; i<N.length; i++) {
				if(N[i]!=tmp) {
					tmp = N[i];
					cnt++;
				}
			}
			System.out.println("#" + testCase + " " + cnt);
			//000에서 N되는거임
			// 111 100 101
			// 0100 0101
			// 1111 1000 1011 1010
			// 1111 1000 1011 
			// 1111 1100
			// 0111 0100
			// 1111 1000 1001
			// 11111 10000 10111 10100 10101
			
		} //tc	
	}
}