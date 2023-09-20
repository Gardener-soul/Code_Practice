import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static int[] num;
	
	public static void union(int x, int y) {
		
		if(x>y) {			
			num[x] = y;
		} else {
			num[y] = x;
		}
		
	}
	
	public static int findset(int x) {
		if(num[x] != x) num[x] = findset(num[x]);
		return num[x];
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase<=T; testCase++) {
			int N = scanner.nextInt(); // 정점의 개수
			int M = scanner.nextInt(); // 간선의 개수
			num = new int [N+1];
			
			for(int i=1; i<=N; i++) {
				num[i] = i;
			}
			
			System.out.print("#" + testCase + " ");
			for(int i=0; i<M; i++) {
				
				int H = scanner.nextInt(); // 합집합인지, 검사인지
				int a = scanner.nextInt(); // 1번 x
				int b = scanner.nextInt(); // 2번 y
			
				int pa = findset(a);
				int pb = findset(b);
				
				if(H==0) { // 합집합
					
					union(pa,pb);
					
				} else { // 검사
					if(num[a]!=num[b]) {
						System.out.print(0);
					} else {
						System.out.print(1);
					}
				}
			}
			System.out.println();
		} // tc
	} // main
}