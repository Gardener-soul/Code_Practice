import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int day, ans;
    static int[][] map;

    public static void dfs(int now, int cnt){

        if(now>=day){
            ans = Math.max(ans,cnt);
            return;
        }

        if(now + map[now][0] <= day){
            dfs(now + map[now][0],cnt+map[now][1]);
        } else{
            dfs(now + map[now][0],cnt);
        }

        dfs(now+1,cnt);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        day = Integer.parseInt(br.readLine());

        map = new int[day][2];
        for(int i=0; i<day; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        ans = 0;

        dfs(0,0);

        System.out.println(ans);
    }
}
