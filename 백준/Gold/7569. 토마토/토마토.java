import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int l, c, r;

    public Tomato(int l, int c, int r) {
        this.l = l;
        this.c = c;
        this.r = r;
    }
}

public class Main {

    static int R, C, L;
    static int[][][] arr;
    // 방향 배열: 좌우, 위아래, 전후 (층)
    static int[] dr = {0, 0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 0, -1, 0, 1};
    static int[] dl = {-1, 1, 0, 0, 0, 0};
    static Queue<Tomato> q = new LinkedList<>();

    public static void bfs() {
        while (!q.isEmpty()) {
            Tomato tmp = q.poll();
            int tr = tmp.r;
            int tc = tmp.c;
            int tl = tmp.l;

            for (int i = 0; i < 6; i++) {
                int der = tr + dr[i];
                int dec = tc + dc[i];
                int del = tl + dl[i];

                // 범위 검사 및 아직 익지 않은 토마토(0)인 경우
                if (der < R && dec < C && del < L && der >= 0 && dec >= 0 && del >= 0 && arr[del][dec][der] == 0) {
                    // 현재 토마토의 날짜 + 1을 이웃에 기록
                    arr[del][dec][der] = arr[tl][tc][tr] + 1;
                    q.offer(new Tomato(del, dec, der));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문제의 입력 순서: M N H (가로, 세로, 층)
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 가로 (열 수)
        C = Integer.parseInt(st.nextToken()); // 세로 (행 수)
        L = Integer.parseInt(st.nextToken()); // 층
        arr = new int[L][C][R];

        // 각 층마다 C개의 줄, 각 줄에 R개의 숫자
        for (int l = 0; l < L; l++) {
            for (int c = 0; c < C; c++) {
                st = new StringTokenizer(br.readLine());
                for (int r = 0; r < R; r++) {
                    arr[l][c][r] = Integer.parseInt(st.nextToken());
                    if (arr[l][c][r] == 1) { // 이미 익은 토마토
                        q.offer(new Tomato(l, c, r));
                    }
                }
            }
        }

        bfs();

        int days = 0;
        for (int l = 0; l < L; l++) {
            for (int c = 0; c < C; c++) {
                for (int r = 0; r < R; r++) {
                    if (arr[l][c][r] == 0) {
                        // 익지 않은 토마토가 있으면
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, arr[l][c][r]);
                }
            }
        }

        // 최초 익은 토마토가 1이므로, 걸린 날짜는 (최대값 - 1)
        System.out.println(days - 1);
    }
}
