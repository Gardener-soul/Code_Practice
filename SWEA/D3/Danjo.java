package D3_Num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = scanner.nextInt();
			int[] num = new int[N];
			for(int tn = 0; tn<N; tn++) {
				num[tn] = scanner.nextInt();
			} // num 배열 완성
			
			List<Integer> gob = new ArrayList<>();
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					gob.add(num[i]*num[j]);
				}
			} // 곱 배열 완성
			
			int max = -1;
			
			for(int i=0; i<gob.size(); i++) {
				
				int a = gob.get(i);
				
				while(a>0) {
					
					int mok = (a/10)%10;
					int na = a%10;
					
					if(na<mok) {
						break;
					}
					
					a/=10;
					
					if(a<10) {
						max = Math.max(gob.get(i), max);
						break;
					}
				}
			}	
			System.out.println("#" + testCase + " " + max);
		} //tc
		
	}
	
}
