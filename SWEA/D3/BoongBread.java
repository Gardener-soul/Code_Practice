package D3_BoongBread;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = scanner.nextInt(); // N개의 정수, 사람 언제 도착하는지
			int M = scanner.nextInt(); // 붕어빵을 이 초에
			int K = scanner.nextInt(); // 이만큼 굽습니다.
			int[] son = new int [N];
			
			for(int n = 0; n<N; n++) {
				son[n] = scanner.nextInt();
			}
			Arrays.sort(son); // 손님을 순서대로 정렬
			String ans = "Possible";
			
			int b;
			for(int i=0; i<son.length; i++) {
				b=son[i]/M * K - (i+1); //붕어빵 공식 손님이 왔을 때를 그 시간 초로 나누고, K를 곱한개 만든 붕어빵의 개수, 손님이 올때마다 하나씩 감소하므로 i+1을 더함.
				if(b<0) {
					ans = "Impossible";
				}
			}
			System.out.println(ans);
		}
	}
}
