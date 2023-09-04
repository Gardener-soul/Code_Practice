import java.util.Scanner;

public class Solution {
	
	static int N;
	static boolean[] visited;
	static int[][] cust;
	static int[][] result;
	static int min;
	static int cx,cy,hx,hy;
	
	public static void perm(int idx) {
	
		if (idx == N) { //각각의 순열이 구해졌음. 이 구간에서 구해지는 순열은 result 배열
			
			int sum = 0; //각각의 순열이 구해질 때마다 sum값 초기화.
			sum += Math.abs(result[0][0]-cx) + Math.abs(result[0][1]-cy) + Math.abs(hx-result[N-1][0]) + Math.abs(hy-result[N-1][1]);
			
			for(int i=1; i<N; i++) { //절댓값으로 뒤에거에서 앞에거 빼기
				sum += Math.abs(result[i][0]-result[i-1][0]) + Math.abs(result[i][1]-result[i-1][1]);
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0; i<N; i++) { //순열을 구하는 재귀파트
			
			if (visited[i]) continue;
			
			result[idx] = cust[i]; //2차원 배열이긴 한데 뭔가 이렇게 해도 섞일 것 같은 느낌.
			visited[i] = true;
			perm(idx+1);
			visited[i] = false; //백트래킹
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt();
			cx = scanner.nextInt(); //회사 x좌표
			cy = scanner.nextInt(); 
			hx = scanner.nextInt();
			hy = scanner.nextInt();
			cust = new int[N][2];
			result = new int[N][2];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				cust[i][0] = scanner.nextInt();
				cust[i][1] = scanner.nextInt();
			} //2차원 배열 잘 받아짐.

			perm(0);
			System.out.println("#" + testCase + " " + min);
			
		} //tc
	} //main
}