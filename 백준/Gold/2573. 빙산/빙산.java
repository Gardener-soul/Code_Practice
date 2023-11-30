import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{

    int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {

    static int R,C, res , ans;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][] map, tmpMap;
    static boolean[][] chk;

    public static void time(int time, int num){

        int sea = 0;

        if(num==1) return;

        outer: for(int i=1; i<=time; i++){
            boolean flag = false;
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(map[r][c]!=0){
                        flag = true;

                        for(int d=0; d<4; d++){
                            int tr = r + dr[d];
                            int tc = c + dc[d];

                            if(tr<R && tc<C && tc>=0 && tr>=0 && map[tr][tc]==0){
                                sea++;
                            }
                        }

                        tmpMap[r][c] -= sea;
                        if(tmpMap[r][c]<0) tmpMap[r][c] =0;

                        sea = 0;

                    }
                }
            }
            if(!flag) return;

            for(int a=0; a<R; a++){
                for(int b=0; b<C; b++){
                    map[a][b] = tmpMap[a][b];
                }
            }

            chk = new boolean[R][C];

            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(tmpMap[r][c]!=0 && !chk[r][c]) {
                        bfs(r,c);
                        res++;
                    }
                }
            }

            // 2개로 갈라졌으면 0을 출력하고 바로 return;
            if(res>=2) {
                ans = i;
                return;
            }

            res = 0;
        }
    }

    public static void bfs(int r, int c){

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));

        while(!q.isEmpty()){
            Pair tmp = q.poll();
            int nr = tmp.r;
            int nc = tmp.c;

            for(int d=0; d<4; d++){

                int tr = nr + dr[d];
                int tc = nc + dc[d];

                if(tr<R && tc<C && tr>=0 && tc>=0 && !chk[tr][tc] && tmpMap[tr][tc]!=0){
                    chk[tr][tc] = true;
                    q.offer(new Pair(tr,tc));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = 0;
        res = 0;
        int maxberg = 0;
        int bergnum = 0;

        chk = new boolean[R][C];
        map = new int[R][C];
        tmpMap = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                tmpMap[r][c] = map[r][c];
                maxberg = Math.max(maxberg,map[r][c]);
                if(map[r][c]>0) bergnum++;
            }
        }

        time(100000, bergnum);

        if(ans==0) System.out.println(ans);
        else System.out.println(ans);

    }
}