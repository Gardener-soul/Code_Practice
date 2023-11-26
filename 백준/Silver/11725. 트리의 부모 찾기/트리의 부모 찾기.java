import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] map;
    static boolean[] chk;
    static int[] res;
    public static void dfs(int a){
        chk[a] = true;

        for(int ans: map[a]){
            if(!chk[ans]){
                dfs(ans);
                res[ans]=a;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            map[i] = new ArrayList<>();
        }

        chk = new boolean[N+1];
        res = new int[N+1];

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        dfs(1);

        for(int i = 2; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}