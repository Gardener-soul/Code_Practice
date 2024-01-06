import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r,c,cnt;
    public Pair(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {
    static int R,C,oneCnt,max;
    static int[] der = {-1,1,0,0};
    static int[] dec = {0,0,-1,1};
    static int[][] map;
    static boolean[][] chk;
    static Queue<Pair> q = new LinkedList<>();

    public static void bfs() {
        int ncnt = 0;
        while (!q.isEmpty()) {

            Pair tmp = q.poll();
            int nr = tmp.r;
            int nc = tmp.c;
            ncnt++;

            for (int d = 0; d < 4; d++) {

                int tr = nr + der[d];
                int tc = nc + dec[d];

                if(tr<R && tc<C && tr>=0 && tc>=0){
                    if(map[tr][tc]==1 && !chk[tr][tc]){
                        q.offer(new Pair(tr,tc,tmp.cnt+1));
                        chk[tr][tc]=true;
                    }
                }
            }
        }
        max = Math.max(max, ncnt);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        oneCnt = 0;
        max = 0;
        map = new int[R][C];
        chk = new boolean[R][C];

        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]==1&&!chk[r][c]){
                    oneCnt++;
                    chk[r][c] = true;
                    q.offer(new Pair(r,c,1));
                    bfs();
                }
            }
        }
        System.out.println(oneCnt);
        System.out.println(max);
    }
}