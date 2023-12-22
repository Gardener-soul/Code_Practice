import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int h,r,c,cnt;

    public Pair(int h, int r, int c, int cnt) {
        this.h = h;
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {

    static int H,R,C;
    static int[] deh = {-1,1,0,0,0,0};
    static int[] der = {0,0,-1,1,0,0};
    static int[] dec = {0,0,0,0,-1,1};
    static int[][][] map;
    static boolean[][][] chk;
    static Queue<Pair> q = new LinkedList<>();

    public static void bfs(){

        while(!q.isEmpty()){

            Pair tmp = q.poll();
            int nh = tmp.h;
            int nr = tmp.r;
            int nc = tmp.c;
            int ncnt = tmp.cnt;

            for(int d=0; d<6; d++){

                int th = nh + deh[d];
                int tr = nr + der[d];
                int tc = nc + dec[d];

                if(th<H && th>=0 && tr<R && tr>=0 && tc<C && tc>=0 && map[th][tr][tc]==0 && !chk[th][tr][tc]){
                    chk[th][tr][tc]= true;
                    map[th][tr][tc] = ncnt+1;
                    q.offer(new Pair(th,tr,tc,ncnt+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][R][C];
        chk = new boolean[H][R][C];
        int zeroCnt = 0;
        int oneCnt = 0;

        for(int h=0; h<H; h++) {
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    map[h][r][c] = Integer.parseInt(st.nextToken());
                    if(map[h][r][c]==0) zeroCnt++;
                    else if(map[h][r][c]==1) {
                        oneCnt++;
                        chk[h][r][c]=true;
                        q.offer(new Pair(h,r,c,0));
                    }
                }
            }
        }

         bfs();

        int max = 0;
        outer : for(int h=0; h<H; h++){
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(map[h][r][c]==0) {
                        max = -1;
                        break outer;
                    } else {
                        max = Math.max(max,map[h][r][c]);
                    }
                }
            }
        }
        
        if (zeroCnt==0) System.out.println(0);
        else if (oneCnt==0) System.out.println(-1);
        else System.out.println(max);
    }
}