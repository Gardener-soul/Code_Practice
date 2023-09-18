import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N; // 정점의 개수
	static int[][] map; // 2차원 배열
	static int[] tri = new int[3]; // 조합 배열
	static int[] num;
	static int triangle;
	
	public static void chkTri(int idx, int angle) {
		
		if(angle == 3) {
			
			if(map[tri[0]][tri[1]]==1&&map[tri[0]][tri[2]]==1&&map[tri[1]][tri[2]]==1)
			triangle++;
			return;
		}
		
		if(idx==N+1) {
			return;
		}
		
		tri[angle] = num[idx];
		chkTri(idx+1, angle+1);
		tri[angle] = 0;
		chkTri(idx+1, angle);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt(); // 정점의 개수
			int M = scanner.nextInt(); // 간선의 개수
			map = new int[N+1][N+1];
			num = new int[N+1];
			triangle = 0;
			
			for(int i=1; i<N+1; i++) {
				num[i] = i;
			}
		
			for(int i=0; i<M; i++) {
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				
				map[A][B] = 1;
				map[B][A] = 1;
			}
			
			chkTri(1,0);
		
			System.out.println("#" + testCase + " " + triangle);
			
		} // tc
	} // main
}