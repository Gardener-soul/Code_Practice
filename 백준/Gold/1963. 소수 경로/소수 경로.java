import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int num, res;
    public Pair(int num, int res) {
        this.num = num;
        this.res = res;
    }
}

public class Main {

    static int res;
    public static int bfs(int start, int end){
        Queue<Pair> q = new LinkedList<>();
        boolean[] chk = new boolean[10000];

        q.offer(new Pair(start,0));
        chk[start] = true;

        while (!q.isEmpty()){

            Pair tmp = q.poll();
            int now = tmp.num;
            int time = tmp.res;

            if(now==end) return time;

            // 이 부분에서 String으로 변환
            String sNow = String.valueOf(now);
            // 한개 한개 씩 접근할 수 있도록 char로 변환
            char[] cNow = sNow.toCharArray();

            for(int i=0; i<4; i++){
                for(int j=0; j<=9; j++){
                    char tmpNum = cNow[i];
                    cNow[i] = (char) (j+'0');

                   int nNow = change(cNow);

                   if(!chk[nNow] && isPrime(nNow) && nNow>1000){
                       chk[nNow] = true;
                       q.offer(new Pair(nNow,time+1));
                   }
                   // 다시 변환
                   cNow[i] = tmpNum;
                }
            }
        }
        return -1;
    }

    public static int change(char[] nums){
        String tmp = "";
        for(int i=0; i<4; i++){
            tmp+=nums[i];
        }
        return Integer.parseInt(tmp);
    }

    public static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            res = 0;

            if(a==b){
                System.out.println(0);
                continue;
            }

            int ans = bfs(a,b);

            if(ans==-1) System.out.println("Impossible");
            else System.out.println(ans);
        }
    }
}