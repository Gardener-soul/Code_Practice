import java.util.*;
import java.io.*;

public class Main {

    static int R,C,max;
    static int[] der = {-1,1,0,0};
    static int[] dec = {0,0,-1,1};
    static int[][] map;
    static boolean[][] chk;

    public static void dfs(int r, int c, int cnt, int sum){

        if(cnt>=4) {
            max = Math.max(sum,max);
            return;
        }

        for(int d=0; d<4; d++){
            int dr = r + der[d];
            int dc = c + dec[d];

            if(dr<R && dc<C && dr>=0 && dc>=0 && !chk[dr][dc]){
                chk[dr][dc] = true;
                dfs(dr,dc,cnt+1,sum+map[dr][dc]);
                chk[dr][dc] = false;
            }
        }

    }

    public static void fuTetris(int r, int c){

    if (r > 0 && r < R - 1 && c < C - 1)
        max = Math.max(max, map[r][c] + map[r - 1][c] + map[r + 1][c] + map[r][c + 1]);

    if (r > 0 && r < R - 1 && c > 0)
        max = Math.max(max, map[r][c] + map[r - 1][c] + map[r + 1][c] + map[r][c - 1]);

    if (r < R - 1 && c > 0 && c < C - 1)
        max = Math.max(max, map[r][c] + map[r][c - 1] + map[r][c + 1] + map[r + 1][c]);

    if (r > 0 && c > 0 && c < C - 1)
        max = Math.max(max, map[r][c] + map[r][c - 1] + map[r][c + 1] + map[r - 1][c]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        chk = new boolean[R][C];
        max = 0;

        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                chk[r][c] = true;
                dfs(r,c,1,map[r][c]);
                chk[r][c] = false;
                fuTetris(r,c);
            }
        }

        System.out.println(max);

    }
}