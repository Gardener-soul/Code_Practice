import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r,c,now;
    public Pair(int r, int c, int now) {
        this.r = r;
        this.c = c;
        this.now = now;
    }
}

public class Main {
    static int R,C, ans;
    static int[] der = {-1,-1,1,1,0,1,0,-1};
    static int[] dec = {-1,1,-1,1,-1,0,1,0};
    static boolean[][] map;
    public static void bfs(int nr, int nc, int now) {
        boolean[][] chk = new boolean[R][C];
        Queue<Pair> q = new LinkedList<>();
        chk[nr][nc] = true;
        q.offer(new Pair(nr, nc, now));

        while (!q.isEmpty()) {

            Pair tmp = q.poll();
            int tr = tmp.r;
            int tc = tmp.c;
            int cnt = tmp.now;

            if(map[tr][tc]) {
                ans = Math.max(ans,cnt);
                break;
            }

            for (int d = 0; d < 8; d++) {
                int dr = tr + der[d];
                int dc = tc + dec[d];

                if (dr >= 0 && dr < R && dc >= 0 && dc < C && !chk[dr][dc]) {
                    chk[dr][dc] = true;
                    q.offer(new Pair(dr, dc, cnt+1));
                } else if (dr>=0 && dr<R && dc>=0 && dc<C && map[dr][dc]){
                    q.offer(new Pair(dr,dc,cnt));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        ans = 0;

        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) map[r][c] = true;
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!map[r][c]) bfs(r,c,0);
            }
        }
        System.out.println(ans);
    }
}
