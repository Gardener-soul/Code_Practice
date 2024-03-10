import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int classNum = Integer.parseInt(st.nextToken());
        int[][] classes = new int[classNum][2];

        for(int i = 0; i < classNum; i++) {
            st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            classes[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 시작 시간을 기준으로 정렬
        Arrays.sort(classes, (a, b) -> a[0] - b[0]);

        // 우선 순위 큐를 사용해 강의실의 종료 시간 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(classes[0][1]);

        for(int i = 1; i < classNum; i++) {
            // 현재 강의의 시작 시간이 큐의 최소 종료 시간보다 크거나 같다면, 강의실 재사용 가능
            if(classes[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(classes[i][1]);
        }

        // 필요한 강의실 수 출력
        System.out.println(pq.size());
    }
}
