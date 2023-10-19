import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N,M;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map, dp;
    
    public static int dfs(int r, int c) {
                
        if(r==N-1 && c==M-1) {
            return 1;
        } 
        
        if(dp[r][c]!=-1) return dp[r][c];
        
        dp[r][c] = 0;
        
        for(int d=0; d<4; d++) {
            int tr = r + dr[d];
            int tc = c + dc[d];
            
            if(tr<N && tc<M && tr>=0 && tc>=0 && map[r][c]>map[tr][tc]) {                    
                    dp[r][c]+=dfs(tr,tc);
            }
        }
        return dp[r][c];
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
            
        }
        
        System.out.println(dfs(0,0));
        
    }
    
}