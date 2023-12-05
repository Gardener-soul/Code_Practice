import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] parent;

    public static int find(int a){
        if(a==parent[a]) return a;
        else return parent[a]=find(parent[a]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y) parent[y]=x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());

                if(a==1) union(i+1,j+1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] travel = new int[M];
        for(int i=0; i<M; i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }

        int start = find(travel[0]);
        boolean flag = false;
        for(int i=1; i<M; i++){
            if(start == find(travel[i])) flag = true;
            else {
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}