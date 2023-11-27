import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int l,r,c,cnt;

    public Pair(int l, int r, int c, int cnt) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {

    static int L,R,C, ans;
    static int el = 0;
    static int er = 0;
    static int ec = 0;
    static char[][][] map;
    static int[] dl = {0,0,0,0,-1,1};
    static int[] dr = {0,1,0,-1,0,0};
    static int[] dc = {1,0,-1,0,0,0};
    static boolean[][][] chk;
    static Queue<Pair> q;

    public static void bfs(){

        while(!q.isEmpty()) {

            Pair tmp = q.poll();
            int tl = tmp.l;
            int tr = tmp.r;
            int tc = tmp.c;
            int tcnt = tmp.cnt;

            if (tl == el && tr == er && tc == ec) {
                System.out.println("Escaped in " + tcnt + " minute(s).");
                return;
            }

            for (int d = 0; d < 6; d++) {

                int del = tl + dl[d];
                int der = tr + dr[d];
                int dec = tc + dc[d];

                if (del < L && der < R && dec < C && del >= 0 && dec >= 0 && der >= 0 && !chk[del][der][dec] && map[del][der][dec] != '#') {
                    chk[del][der][dec] = true;
                    q.offer(new Pair(del, der, dec, tcnt + 1));
                }
            }
        }
        System.out.println("Trapped!");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            ans = 0;

            q = new LinkedList<>();

            chk = new boolean[L][R][C];
            map = new char[L][R][C];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String tmp = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = tmp.charAt(c);
                        if (map[l][r][c] == 'S') {
                            chk[l][r][c] = true;
                            q.offer(new Pair(l, r, c, 0));
                        }
                        if (map[l][r][c] == 'E') {
                            el = l;
                            er = r;
                            ec = c;
                        }
                    }
                }
                br.readLine(); // 빈칸
            }

            bfs();

        }
    }
}