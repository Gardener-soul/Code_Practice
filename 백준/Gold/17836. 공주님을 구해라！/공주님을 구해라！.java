import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r,c,cnt;
    boolean sword;

    public Pair(int r, int c, int cnt, boolean sword) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.sword = sword;
    }
}

public class Main {

    static int R,C,time, ans;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][] map;
    static boolean[][][] chk;
    static Queue<Pair> q;

    public static void bfs(int r, int c){

        while(!q.isEmpty()){

            Pair tmp = q.poll();
            int nr = tmp.r;
            int nc = tmp.c;
            int ncnt = tmp.cnt;
            boolean nsword = tmp.sword;

            if(ncnt>time){
                System.out.println("Fail");
                return;
            }

            if(nr == R-1 && nc == C-1){
                if(ncnt>time) System.out.println("Fail");
                else System.out.println(ncnt);
                return;
            }

            for(int d=0; d<4; d++){
                int tr = nr + dr[d];
                int tc = nc + dc[d];

                if(tr<R && tc<C && tr>=0 && tc>=0){
                    if(!nsword){
                        if(map[tr][tc]==0 && !chk[tr][tc][0]){
                            q.offer(new Pair(tr,tc,ncnt+1,false));
                            chk[tr][tc][0] = true;
                        }
                        else if (map[tr][tc]==2 && !chk[tr][tc][0]) {
                            q.offer(new Pair(tr,tc,ncnt+1,true));
                            chk[tr][tc][1] = true;
                        }
                    } else if(nsword) {
                        if(!chk[tr][tc][1]){
                            chk[tr][tc][1] = true;
                            q.offer(new Pair(tr,tc,ncnt+1,true));
                        }
                    }
                }
            }
        }
        System.out.println("Fail");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        ans = 0;

        map = new int[R][C];
        chk = new boolean[R][C][2];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();

        if(map[0][0]==2) {
            chk[0][0][1] = true;
            q.offer(new Pair(0,0,0, true));
        }
        else {
            chk[0][0][0] = true;
            q.offer(new Pair(0,0,0, false));
        }
        bfs(0,0);
    }
}
