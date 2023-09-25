import java.util.*;

class Solution {

    static int[][] map;
	static Queue<Integer> q;
	static boolean[] chk;
    
    	public static int bfs(int n, int start) {
		
		int cnt = 1;
		q.offer(start);
		chk[start] = true;
		
		while(!q.isEmpty()) {
			
			int tmp = q.poll();
			for(int i=1; i<=n; i++) {
				if(!chk[i]&&map[tmp][i]==1) {
					q.offer(i);
					chk[i] = true;
					cnt++;
				}
			}
			
		}
		 return (int)Math.abs(n-2*cnt);
	}
    
    public int solution(int n, int[][] wires) { // n : 송전탑의 개수
        int answer = n;
        map = new int[n+1][n+1];
        q = new LinkedList<>();
        
        for(int i=0; i<wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int i=0; i<wires.length; i++) {
			chk = new boolean[n+1];
			
			int a = wires[i][0];
			int b = wires[i][1];
			
			map[a][b] = 0;
			map[b][a] = 0;
			
			answer = Math.min(answer, bfs(n, i+1));
			
			map[a][b] = 1;
			map[b][a] = 1;
			
		}
        
        return answer;
    }
}