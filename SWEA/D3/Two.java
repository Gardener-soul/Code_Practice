package Two;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			String ans = "OFF";
			int N = scanner.nextInt();
			int num = scanner.nextInt();
			int cnt=0;
			
			for(int i=0; i<N; i++) {
				if((num & 1) == 1) {
					num = (num >> 1);
					cnt++;
				} else break;
			}
			
			if(cnt==N) {
				ans = "ON";
				System.out.println("#" + testCase + " " + ans);
			} else {System.out.println("#" + testCase + " " + ans);}
			
		} //tc
	}
}
