import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int day = Integer.parseInt(st.nextToken()); // n일동안 가장 많이 들어온 사람
        int[] arr = new int[N];
        int sum = 0; // 누적합
        int sta = 1; // 같은 날

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<day; i++) {
            sum += arr[i];
        }

        int max = Math.max(sum,0);

        for(int i=1; i<=N-day; i++) {
            if(day+i>N) break;

            sum-=arr[i-1];
            sum+=arr[day+i-1];

            if(max==sum) sta++;
            else if(max<sum) sta=1;

            max = Math.max(max,sum);
        }

        if(max!=0) System.out.println(max);
        if(max==0) System.out.println("SAD");
        else System.out.println(sta);

    }
}
