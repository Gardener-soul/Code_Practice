import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int now, sum;

    public Pair(int now, int sum) {
        this.now = now;
        this.sum = sum;
    }
}

public class Main {

    static int start, end, ans;
    static boolean[] chk;

    public static int bfs(int s, int e) {

        Queue<Pair> q = new LinkedList<>();
        chk[s] = true;
        q.offer(new Pair(s, 0));

        while (!q.isEmpty()) {

            Pair tmp = q.poll();
            int now = tmp.now;
            int sum = tmp.sum;

            if (now == e) {
                return sum;
            }

            if (now + 1 >= 0 && now + 1 <= 100000 && !chk[now + 1]) {
                chk[now + 1] = true;
                q.offer(new Pair(now + 1, sum + 1));
            }
            if (now - 1 >= 0 && now - 1 <= 100000 && !chk[now - 1]) {
                chk[now - 1] = true;
                q.offer(new Pair(now - 1, sum + 1));
            }
            if (now * 2 >= 0 && now * 2 <= 100000 && !chk[now * 2]) {
                chk[now * 2] = true;
                q.offer(new Pair(now * 2, sum + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        chk = new boolean[100001];

        ans = bfs(start, end);

        System.out.println(ans);
    }
}