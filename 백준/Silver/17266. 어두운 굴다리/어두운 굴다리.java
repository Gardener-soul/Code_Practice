import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lights = new int[n];
        for (int i = 0; i < n; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }
        
        // 첫 가로등과 0 사이의 거리, 마지막 가로등과 다리 끝 사이의 거리
        int maxDistance = Math.max(lights[0], len - lights[n - 1]);
        
        // 인접 가로등 사이의 최대 간격의 절반 (올림)
        for (int i = 0; i < n - 1; i++) {
            int gap = lights[i + 1] - lights[i];
            // gap의 절반을 올림 처리
            int required = (gap + 1) / 2;
            maxDistance = Math.max(maxDistance, required);
        }
        
        System.out.println(maxDistance);
    }
}
