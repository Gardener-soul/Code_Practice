import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r, c, cnt, jum;

    public Pair(int r, int c, int cnt, int jum) {
        super();
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.jum = jum;
    }
}

public class Main {
    
    static int jump, R,C;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] hr = {-1,-2,-2,-1,1,2,2,1};
    static int[] hc = {-2,-1,1,2,2,1,-1,-2};
    static int[][] map;
    static boolean[][][] chk;
    static Queue<Pair> q = new LinkedList<>();
    
    public static void bfs(int sr, int sc) {
       
       q.offer(new Pair(sr,sc,0,0));
    	
       while(!q.isEmpty()) {
    	   
    	   Pair tmp = q.poll();
    	   int nr = tmp.r;
    	   int nc = tmp.c;
    	   int cnt = tmp.cnt;
    	   int horse = tmp.jum;
    	   
    	   if(nr==R-1 && nc==C-1) {
    		   min = Math.min(min, cnt);
    		   return;
    	   }
    	   
    	   for(int d=0; d<4; d++) {
    		   
    		   int tr = nr + dr[d];
    		   int tc = nc + dc[d];
    		   
    		   if(tr<R && tc<C && tr>=0 && tc>=0 && !chk[horse][tr][tc]) {
    			   for(int i = horse ; i<=jump; i++) {
    				   chk[i][tr][tc] = true;
    			   }
    			   q.offer(new Pair(tr,tc,cnt+1,horse));
    		   }
    	   }
    	   
    	   if(horse<jump) {
    		   for(int d=0; d<8; d++) {
    			   int jr = nr + hr[d];
    			   int jc = nc + hc[d];
    			   
    			   if(jr<R && jc<C && jr>=0 && jc>=0 && !chk[horse+1][jr][jc]) {
    				   for(int i=horse+1; i<=jump; i++) {
    					   chk[i][jr][jc] = true;
    				   }
    				   q.offer(new Pair(jr,jc,cnt+1,horse+1));
    			   }
    		   }
    	   }
       }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        jump = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        chk = new boolean[jump+1][R][C];
        
        for(int r=0; r<R; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                for(int i=0; i<=jump; i++) {
                	if(map[r][c]==1) chk[i][r][c]=true;
                }
            }
        }
        
        bfs(0,0);
        
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}