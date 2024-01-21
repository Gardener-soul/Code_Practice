import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r,c;
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int R,C,max,tmpa;
    static int[] der = {-1,1,0,0};
    static int[] dec = {0,0,-1,1};
    static boolean[][] map;
    static Queue<Pair> q = new LinkedList<>();
    public static void bfs(int r, int c){
        q.offer(new Pair(r,c));
        tmpa = 0;

        while(!q.isEmpty()){
            Pair tmp = q.poll();

            int tr = tmp.r;
            int tc = tmp.c;

            for(int d=0; d<4; d++){
                int dr = tr + der[d];
                int dc = tc + dec[d];

                if(dr<R && dc<C && dr>=0 && dc>=0 && map[dr][dc]){
                    q.offer(new Pair(dr,dc));
                    map[dr][dc] = false;
                    tmpa++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = 0;
        map = new boolean[R][C];

        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());

            int tmpr = Integer.parseInt(st.nextToken())-1;
            int tmpc = Integer.parseInt(st.nextToken())-1;

            map[tmpr][tmpc] = true;
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]) {
                    bfs(r,c);
                    max = Math.max(max,tmpa);
                }
            }
        }
        System.out.println(max);
    }
}
