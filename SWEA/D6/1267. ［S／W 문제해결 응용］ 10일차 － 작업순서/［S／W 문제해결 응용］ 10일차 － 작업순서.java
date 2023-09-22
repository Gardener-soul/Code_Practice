import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static boolean[] chk;
	static Stack<Integer> stack;
	static int V;
	static int[][] map;
	
	public static void DFS(int level) {
		
		chk[level] = true;
		
		for(int i=1; i<=V; i++) {
			
			if(!chk[i]&&map[level][i]==1) {
				
				DFS(i);
				
			}
			
		}
		
		stack.add(level);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int testCase = 1; testCase<=10; testCase++) {
			V = scanner.nextInt(); // 정점의 개수
			int E = scanner.nextInt(); // 간선의 개수
			
			int[] degree = new int [V+1];
			chk = new boolean[V+1];
			stack = new Stack<>();
			map  = new int[V+1][V+1];
			
			for(int i=0; i<E; i++) {
				
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				map[a][b] = 1;
				
				degree[b]++;
				
			}
			
			for(int i=1; i<V+1; i++) {
				if(degree[i]==0) {
					DFS(i);
				}
			}
			
			System.out.print("#" + testCase + " ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
}