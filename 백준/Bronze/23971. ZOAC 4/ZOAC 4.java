import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double R = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        double ar = Double.parseDouble(st.nextToken()) +1; // 세로 간격
        double ac = Double.parseDouble(st.nextToken()) +1; // 가로 간격

        int r = (int) Math.ceil(R/ar);
        int c = (int) Math.ceil(C/ac);

        System.out.println(r*c);

    }
}
