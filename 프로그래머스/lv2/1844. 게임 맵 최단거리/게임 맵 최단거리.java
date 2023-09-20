import java.util.*;

class Pair{
    
    int x,y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}

class Solution {
    static int N, M;
    static Queue<Pair> q = new LinkedList<>();
    static boolean[][] chk;
    static int[][] res;
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] maps;
    
    public static void bfs(int x, int y){
        
        chk[x][y] = true;
        res[x][y] = 1;
        
        q.offer(new Pair(x, y));
        
        while(!q.isEmpty()){
            
            Pair t = q.poll();
            
            for(int d=0; d<4; d++){
                
                int tr = t.x + dr[d];
                int tc = t.y + dc[d];
                
                if(tr<N && tc<M && tr>=0 && tc>=0){
                    if(!chk[tr][tc]&&maps[tr][tc]!=0){
                        q.offer(new Pair(tr,tc));
                        chk[tr][tc] = true;
                        res[tr][tc] = res[t.x][t.y] + 1;
                    }
                }
                
            }
            
        }
        
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        chk = new boolean [N][M];
        res = new int [N][M];
        
        bfs(0,0);
        
        if(res[N-1][M-1]==0){
            answer = -1;
        } else {
            answer = res[N-1][M-1];
        }
        
        return answer;
    }
}