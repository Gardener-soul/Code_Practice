import java.util.Scanner;

public class Solution{
	
	static boolean[] sel; //부분집합을 구할 때, T or F
	static int[] arr; //사람 수가 담긴 배열
	static int N,S, min;
	
	static void powerset(int idx) {
		
		if(idx == N) {
			
			int sum=0; // 기저 조건에 들어왔을 때 부분집합들이 완성되므로 이 때마다 sum을 0으로 초기화.
			
			for(int i=0; i<N; i++) {
				if(sel[i]) {
					sum+=arr[i]; // sum은 지금 부분집합들의 합이 됨. 이 중에서 S와 가까운 수를 찾아야함.
				}
			}
			
			// 높이가 S이상인 sum들만을 대상으로 해야함.
			if(sum>=S) {
				min = Math.min(min, sum-S);
			}
			return;
		
		}
		
		sel[idx] = false;
		powerset(idx+1);
		sel[idx] = true;
		powerset(idx+1);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt(); //사람 수, 배열 크기
			S = scanner.nextInt(); //선반의 높이
			arr = new int [N];
			sel = new boolean[N];
			min = 987654321;
			
			for(int i=0; i<N; i++) {
				arr[i] = scanner.nextInt();
			}
			
			powerset(0);
			System.out.println("#" + testCase + " " + min);
			
		} //tc
	}//main
}