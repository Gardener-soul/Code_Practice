import java.util.Scanner;

public class Solution {
	
	static int[] num;
	
	public static void union(int x, int y) {
		
		if(x>y) {
			num[x] = y;
		} else {
			num[y] = x;
		}
		
	}
	
	public static int findset(int x) {
		
		if(num[x]!=x) {
			num[x] = findset(num[x]);
		}
		return num[x];
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			int N = scanner.nextInt(); // 사람의 명수
			int M = scanner.nextInt(); // 관계의 수
			num = new int [N+1];
			
			for(int i=1; i<=N; i++) {
				num[i] = i;
			}
			
			for(int i=0; i<M; i++) {
				int a = scanner.nextInt(); // 주민 1
				int b = scanner.nextInt(); // 주민 2
				
				int pa = findset(a);
				int pb = findset(b);
				
				union(pa,pb);
				
			}
			
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				if(num[i] == i) {
					cnt++;
				}
			}
			
			System.out.println("#" + testCase + " " + cnt);
			
		}
		
	}

}