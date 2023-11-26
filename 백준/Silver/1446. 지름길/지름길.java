import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int ans, D;
    static ArrayList<int[]> map = new ArrayList<int[]>();

    public static void dfs(int v, int dist){
        if(dist>=ans) return;
        if(v==D){
            ans=dist;
            return;
        }
        // 지름길 사용
        for(int i=0; i<map.size(); i++){
            int[] now = map.get(i);
            if(now[0]==v) dfs(now[1],dist+now[2]);
        }
        // 그냥 사용
        dfs(v+1,dist+1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b > D) continue; // 도착점이 목적지보다 크면 걍 패스
            if (b - a <= c) continue; // 이건 지름길이 아님.

            map.add(new int[]{a, b, c});
        }
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(ans);
    }
}