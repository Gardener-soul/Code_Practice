import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long r,c,w,s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        w = Long.parseLong(st.nextToken());
        s = Long.parseLong(st.nextToken());

        // 수평으로만, 대각선으로만, 대각선까지 이동후 수평으로만
        long sum1, sum2, sum3;

        sum1 = (r+c) * w;

        if((r+c)%2==0) sum2=Math.max(r,c) * s;
        else sum2=(Math.max(r,c)-1)*s + w;

        sum3 = Math.min(r,c)*s + Math.abs(r-c) * w;

        System.out.println(Math.min(Math.min(sum1,sum2),sum3));
    }
}
