import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE, tmp=1;
    static boolean[] chk;
    
    public static void dfs(boolean[][] map, int start, int n) {
        chk[start] = true;
        tmp++;
        
        for(int i=1; i<=n; i++) {
            if(!chk[i] && map[start][i]) {

                dfs(map, i,n);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        boolean[][] map = new boolean[n+1][n+1];
        for(int i=0; i<wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            map[start][end] = true;
            map[end][start] = true;
        }
        
        for(int i=0; i<wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            map[start][end] = false;
            map[end][start] = false;
            
            chk = new boolean[n+1];
            
            tmp = 0;
            dfs(map, start, n);
            
            int a = tmp;
            int b = n-tmp;
            
            min = Math.min(min, Math.abs(a-b));
            
            map[start][end] = true;
            map[end][start] = true;
        }
        
        return min;
    }
}