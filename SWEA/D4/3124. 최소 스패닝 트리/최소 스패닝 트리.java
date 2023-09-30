import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	static int[] num;
	
	public static int findset(int idx) {
		
		if(num[idx]!= idx) {
			num[idx] = findset(num[idx]);
		}
		return num[idx];
	}
	
	public static void union(int x, int y) {
		if(x>y) {
			num[x] = y;
		} else {
			num[y] = x;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			int V = scanner.nextInt(); // 정점
			int E = scanner.nextInt(); // 간선
			
			int[][] map = new int[E][3];
			
			for(int i=0; i<E; i++) {
				map[i][0] = scanner.nextInt();
				map[i][1] = scanner.nextInt();
				map[i][2] = scanner.nextInt();
			}
		
			num = new int[V+1];
			for(int i=1; i<=V; i++) {
				num[i] = i;
			}
			
			Arrays.sort(map, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2]-o2[2];
				}
			});
			
			long ans = 0;
			int pick = 0;
			
			for(int i=0; i<E; i++) {
			
				int px = findset(map[i][0]);
				int py = findset(map[i][1]);
				
				if(px!=py) {
					union(px,py);
					ans+=map[i][2];
					pick++;
				}
				if(pick==V) break;
			}
			
			System.out.println("#" + testCase + " " + ans);
			
		}
		
	}
}