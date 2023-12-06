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

    static int start, end, ans, res;
    static int[][] num;
    static boolean[] chk;

    public static int bfs(int s, int e) {

        Queue<Pair> q = new LinkedList<>();
        int exact = 0;
        q.offer(new Pair(s, 0));

        while (!q.isEmpty()) {

            Pair tmp = q.poll();
            int now = tmp.now;
            int sum = tmp.sum;

            if (now == e) {
                if(num[now][0]>sum){
                    num[now][0] = sum;
                    exact=sum;
                    res = sum;
                }

                if(num[now][0]==sum) num[now][1]++;
            }

            if(res<sum) return exact;

            if (now + 1 >= 0 && now + 1 <= 100000 && num[now+1][0]>=sum) {
                num[now+1][0] = sum;
                if(num[now+1][0]==sum) num[now+1][1]++;
                q.offer(new Pair(now + 1, sum + 1));
            }
            if (now - 1 >= 0 && now - 1 <= 100000 && num[now-1][0]>=sum) {
                num[now-1][0] = sum;
                if(num[now-1][0]==sum) num[now-1][1]++;
                q.offer(new Pair(now - 1, sum + 1));
            }
            if (now * 2 >= 0 && now * 2 <= 100000 && num[now*2][0]>=sum) {
                num[now*2][0] = sum;
                if(num[now*2][0]==sum) num[now*2][1]++;
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
        num = new int[100011][2];
        res = Integer.MAX_VALUE;

        for(int i=0; i<100001; i++){
            num[i][0] = Integer.MAX_VALUE;
        }

        ans = bfs(start, end);

        if(start == end) num[end][0]=-1;

        System.out.println(num[end][0]+1);
        System.out.println(num[end][1]);
    }
}
