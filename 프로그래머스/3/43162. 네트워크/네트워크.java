import java.util.*;

class Solution {
    
    static int R,C;
    static int cnt = 0;
    
    public void dfs(int[][] a, boolean[][] b, int nr , int nc){
        b[nr][nc] = true;
        for(int c=0; c<C; c++){
            if(a[nc][c]==1 && !b[nc][c]) {
                dfs(a,b,nc,c);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        R = computers.length;
        C = computers[0].length;
        
        boolean[][] chk = new boolean[R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(computers[r][c]==0) chk[r][c] = true;
                if(!chk[r][c] && computers[r][c]==1){
                    dfs(computers, chk, r,c);
                    answer++;
                    // System.out.println(Arrays.deepToString(chk));
                }
            }
        }
                    // System.out.println(Arrays.deepToString(chk));

        return answer;
    }
}