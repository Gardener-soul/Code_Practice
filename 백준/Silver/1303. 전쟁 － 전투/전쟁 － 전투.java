import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int cnt = 0;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static char[][] map;
    static boolean[][] chk;
    public static void dfs(int r, int c, char a){

        chk[r][c] = true;
        cnt++;

        for(int d=0; d<4; d++) {
            int tr = r + dr[d];
            int tc = c + dc[d];
            if (tr < N && tc < M && tr >= 0 && tc >= 0 && !chk[tr][tc] && map[tr][tc] == a) {
                chk[tr][tc] = true;
                dfs(tr, tc, a);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int sumb = 0;
        int sumw = 0;

        chk = new boolean[N][M];
        map = new char[N][M];
        for(int r=0; r<N; r++){
            String tmp = br.readLine();
            for(int c=0; c<M; c++){
                map[r][c] = tmp.charAt(c);
            }
        }

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(!chk[r][c] && map[r][c]=='B'){
                    cnt=0;
                    dfs(r,c,map[r][c]);
                   sumb+= (int) Math.pow(cnt,2);
                } else if(!chk[r][c] && map[r][c] =='W'){
                    cnt=0;
                    dfs(r,c,map[r][c]);
                    sumw+= (int) Math.pow(cnt,2);
                }
            }
        }

        System.out.println(sumw + " " + sumb);

    }
}